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
 * 收藏视频表
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutdoorVideoCollect对象", description="收藏视频表")
public class OutdoorVideoCollect implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "收藏id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "收藏的视频id")
    private Long videoId;

    @ApiModelProperty(value = "创作者id")
    private Long upId;

    @ApiModelProperty(value = "收藏者id")
    private Long fanId;

    @ApiModelProperty(value = "收藏夹id")
    private Long favoriteId;

    @ApiModelProperty(value = "0收藏，1未收藏")
    private Boolean isDeleted;

    @ApiModelProperty(value = "收藏时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更改时间")
    private Date gmtModified;


}
