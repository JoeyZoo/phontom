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
 * 
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutdoorPraise对象", description="")
public class OutdoorPraise implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "赞的id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "获赞的视频id或者评论id")
    private Long sourceId;

    @ApiModelProperty(value = "0视频，1评论")
    private Integer source;

    @ApiModelProperty(value = "点赞者id")
    private Long fanId;

    @ApiModelProperty(value = "获赞者id")
    private Long upId;

    @ApiModelProperty(value = "0赞，1未赞")
    private Boolean isDeleted;

    @ApiModelProperty(value = "点赞的时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;


}
