package com.zj.userservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutdoorUser对象", description="")
public class OutdoorUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "使用邮箱或者手机号注册，然后通过发送验证邮件或者手机验证码确认是否有效")
    private String account;

    @ApiModelProperty(value = "粘贴默认头像地址")
    private String avatar;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "1代表男，2代表女")
    private Integer sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "个性签名")
    private String motto;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String phonenumber;

    @ApiModelProperty(value = "0普通，1大会员")
    private Boolean isMember;

    @ApiModelProperty(value = "1在线，0下线，登录后修改该字段的值")
    private Boolean isOnline;

    @ApiModelProperty(value = "0未冻结，1冻结")
    private Boolean isDisabled;

    @ApiModelProperty(value = "0正常，1注销")
    private Boolean isDeleted;

    @ApiModelProperty(value = "注册时间")
    @TableField(fill = FieldFill.INSERT,value ="gmt_create")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE,value = "gmt_modified")
    private Date gmtModified;


}
