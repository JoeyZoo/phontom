package com.zj.userservice.controller;


import com.zj.baseservice.utils.JwtUtils;
import com.zj.baseservice.common.R;
import com.zj.userservice.entity.vo.LoginVO;
import com.zj.userservice.entity.OutdoorUser;
import com.zj.userservice.entity.vo.RegistVO;
import com.zj.userservice.service.OutdoorUserService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/userservice/user")
@CrossOrigin
public class OutdoorUserController {

    @Autowired
    private OutdoorUserService outdoorUserService;

    @PostMapping("/regist")
    @ApiOperation("用户注册")
    public R regist(@RequestBody RegistVO registVo) {
        int regist= outdoorUserService.regist(registVo);
        if(regist>0) {
            return R.ok().message("注册成功");
        } else {
            return R.error().message("注册失败");// 注册失败提示未能返回前端
        }
    }

    @PostMapping("/login")// 如果是get请求，则不能使用@RequestBody注解
    @ApiOperation("用户登录")
    public R login(@RequestBody LoginVO loginVo){
        R r = outdoorUserService.login(loginVo);
        return r;
    }

    @GetMapping("/getUserInfo")
    @ApiOperation("获取用户信息")
    public R getUserInfo(HttpServletRequest request){
        Claims c = JwtUtils.getMemberIdByJwtToken(request);
        OutdoorUser outdoorUser = outdoorUserService.getById((Serializable) c.get("id"));
        return R.ok().data("outdoorUser",outdoorUser).data("id",c.get("id"));
    }
}

