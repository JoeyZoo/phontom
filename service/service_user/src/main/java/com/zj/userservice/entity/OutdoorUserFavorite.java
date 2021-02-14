package com.zj.userservice.entity;

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
 * 用户收藏夹表
 * </p>
 *
 * @author zj
 * @since 2020-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutdoorUserFavorite对象", description="用户收藏夹表")
public class OutdoorUserFavorite implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "收藏夹id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "收藏夹名称")
    private String favoriteName;

    @ApiModelProperty(value = "用户id")
    private Long uid;

    @ApiModelProperty(value = "0正常,1逻辑删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "收藏夹创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "收藏夹更新时间")
    private Date gmtModified;


}
