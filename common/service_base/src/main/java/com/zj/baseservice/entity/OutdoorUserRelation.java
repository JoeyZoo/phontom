package com.zj.baseservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户关系表
 * </p>
 *
 * @author zj
 * @since 2020-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutdoorUserRelation对象", description="用户关系表")
public class OutdoorUserRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "up主id")
    private Long upId;

    @ApiModelProperty(value = "粉丝id")
    private Long fanId;

    @ApiModelProperty(value = "逻辑删除 1（true）取消关注，0（false）关注")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间，即关注up时间点")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间，即取关时间点")
    private Date gmtModified;
}
