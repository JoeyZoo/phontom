package com.zj.smsservice.controller;

import com.zj.baseservice.common.R;
import com.zj.smsservice.service.SmsService;
import com.zj.smsservice.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/smsservice")
@Api("验证码接口")
@CrossOrigin
public class SmsController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/sendSms/{PhoneNumbers}")
    @ApiOperation("发送验证码给用户手机")//uri路径和方法参数要一致，并且要和阿里云官方文档要求的参数名字相同，PhoneNumbers
    public R sendSms(@PathVariable String PhoneNumbers) {
        // 首先从redis缓存中查找是否存在对应的phonenumber
        String code = (String)redisTemplate.opsForValue().get(PhoneNumbers);
        if (!StringUtils.isEmpty(code)) {
            return R.ok().message("验证码仍有效");
        }
        // 如果redis中不存在phonenumber对应的code，则创建一个随机的数字
        String randomSix = RandomUtil.getSix();
        HashMap<String, String> map = new HashMap<>();
        map.put("code", randomSix);
        Boolean isSend = smsService.sendSms(PhoneNumbers, map);
        if (isSend) {
            //FIXME 为什么redis中的数据没有得到及时更新？并且为什么没有及时从redis缓存中先查询有没有数据？
            //FIXME 为什么key(PhoneNumbers)在redis中的值会变为\xac\xed\x00\x05t\x00\x0b13162679462？
            redisTemplate.opsForValue().set(PhoneNumbers, randomSix, 5, TimeUnit.MINUTES);
            return R.ok().message("发送验证码成功");
        } else {
            return R.ok().message("发送验证码失败");
        }
    }
}
