package com.zj.userservice.service;

import com.zj.baseservice.common.R;
import com.zj.userservice.entity.vo.LoginVO;
import com.zj.userservice.entity.OutdoorUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.userservice.entity.vo.RegistVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
public interface OutdoorUserService extends IService<OutdoorUser> {

    // 用户注册
    int regist(RegistVO registVo);

    // 用户登录
    R login(LoginVO loginVo);


}
