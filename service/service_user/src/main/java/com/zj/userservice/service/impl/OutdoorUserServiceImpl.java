package com.zj.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.baseservice.utils.JwtUtils;
import com.zj.baseservice.common.OutdoorException;
import com.zj.baseservice.common.R;
import com.zj.baseservice.utils.MD5;
import com.zj.userservice.entity.vo.LoginVO;
import com.zj.userservice.entity.OutdoorUser;
import com.zj.userservice.entity.vo.RegistVO;
import com.zj.userservice.mapper.OutdoorUserMapper;
import com.zj.userservice.service.OutdoorUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@Service
public class OutdoorUserServiceImpl extends ServiceImpl<OutdoorUserMapper, OutdoorUser> implements OutdoorUserService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public int regist(RegistVO registVo) {
        // 获取注册对象属性
        String phonenumber = registVo.getPhonenumber();
        String nickname = registVo.getNickname();
        String password = registVo.getPassword();
        String code = registVo.getCode();
        // 对属性进行非空验证
        if (StringUtils.isEmpty(phonenumber) || StringUtils.isEmpty(nickname)
                || StringUtils.isEmpty(password) ||StringUtils.isEmpty(code)){
            throw new OutdoorException("注册内容不能空着哦", 20001);//异常信息未能返回到前端
          }
        // 判断是否该手机号已被注册
        QueryWrapper<OutdoorUser> userWrapper = new QueryWrapper<>();
        userWrapper.eq("phonenumber", phonenumber);
        Integer count = baseMapper.selectCount(userWrapper);
        if (count>0) {
            throw new OutdoorException("该手机号已注册", 20001);
        }
        // 判断昵称是否已被注册
        QueryWrapper<OutdoorUser> userWrapper2 = new QueryWrapper<>();
        userWrapper2.eq("nickname", nickname);
        Integer count2 = baseMapper.selectCount(userWrapper2);
        if (count2>0) {
            throw new OutdoorException("该昵称已被其他用户使用", 20001);
        }
        //判断密码长度
        int length = password.toCharArray().length;
        if (length>11 || length<6) {
            throw new OutdoorException("请输入6~11位的密码", 20001);
        }
        //判断短信验证码是否正确
        String checkCode = redisTemplate.opsForValue().get(phonenumber);
        if (!code.equals(checkCode)) {//该处从redis中获得的验证码和手动传入的验证码不一致
            throw new OutdoorException("验证码错误", 20001);
        }
        OutdoorUser newUser = new OutdoorUser();
        newUser.setPhonenumber(phonenumber);
        newUser.setNickname(nickname);
        newUser.setPassword(MD5.encrypt(password));
        newUser.setAccount(phonenumber);
        newUser.setGmtCreate(new Date());
        newUser.setGmtModified(new Date());
        int insert = baseMapper.insert(newUser);
        return insert;
    }

    @Override
    public R login(LoginVO loginVo) {
        String account = loginVo.getAccount();
        String password = loginVo.getPassword();
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return R.error().message("账号或密码不能为空");
        }
        //查找数据库是否有对应的账号和密码
        QueryWrapper<OutdoorUser> userWrapper = new QueryWrapper<>();
        userWrapper.eq("account", account);
        userWrapper.eq("password", MD5.encrypt(password));
        OutdoorUser outdoorUser = baseMapper.selectOne(userWrapper);
        if (outdoorUser == null) {
            return R.error().message("用户名或密码错误");
        }
        Long id = outdoorUser.getId();
        String nickname = outdoorUser.getNickname();
        String token = JwtUtils.getJwtToken(id, nickname);
        return R.ok().data("token", token).message("登录成功");
    }
}
