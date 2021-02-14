package com.zj.userservice.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistVO {
    private String phonenumber;// 用户手机号
    private String nickname;// 用户昵称
    private String password;// 用户密码
    private String code;// 阿里云短信验证，验证手机号是否真实有效
}
