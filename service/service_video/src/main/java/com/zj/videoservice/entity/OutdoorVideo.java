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
 * 视频信息表
 * </p>
 *
 * @author zj
 * @since 2020-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutdoorVideo对象", description="视频信息表")
public class OutdoorVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "视频id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "视频标题")
    private String title;

    @ApiModelProperty(value = "视频所属分类id")
    private Integer typeId;//只允许选择一个分类

    @ApiModelProperty(value = "视频简介")
    private String description;

    @ApiModelProperty(value = "视频封面")
    private String cover;

    @ApiModelProperty(value = "视频时长")
    private Date duration;

    @ApiModelProperty(value = "云端视频id")
    private String videoSourceId;

    @ApiModelProperty(value = "云端视频原始名")
    private String videoOriginalName;

    @ApiModelProperty(value = "视频作者id")
    private Long upId;

    @ApiModelProperty(value = "1为免费,0为付费")
    private Boolean isFree;

    @ApiModelProperty(value = "1已发表,0未发表")
    private Boolean isPublished;

    @ApiModelProperty(value = "0正常，1被禁/被下架")
    private Boolean isDisabled;

    @ApiModelProperty(value = "0正常，1逻辑删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;


}
