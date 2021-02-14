package com.zj.videoservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Arrays;
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
 * 播放历史表
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutdoorVideoPlayRecord对象", description="播放历史表")
public class OutdoorVideoPlayRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "播放id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "播放的视频id")
    private Long videoId;

    @ApiModelProperty(value = "播放者id")
    private Long fanId;

    @ApiModelProperty(value = "视频作者id")
    private Long upId;

    @ApiModelProperty(value = "0播放历史1清除历史")
    private Boolean isDeleted;

    @ApiModelProperty(value = "播放时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "清除历史时间")
    private Date gmtModified;


}
