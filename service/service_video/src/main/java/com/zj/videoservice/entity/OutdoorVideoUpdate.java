package com.zj.videoservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * UP主动态通知表
 * </p>
 *
 * @author zj
 * @since 2021-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutdoorVideoUpdate对象", description="UP主动态通知表")
public class OutdoorVideoUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "视频云端id")
    private String videoSourceId;

    @ApiModelProperty(value = "up_id")
    private Long upId;

    @ApiModelProperty(value = "fan_id")
    private Long fanId;

    @ApiModelProperty(value = "0为未查阅，1为已查阅")
    private Boolean isDeleted;

    @ApiModelProperty(value = "动态通知时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "查阅时间")
    private Date gmtModified;


}
