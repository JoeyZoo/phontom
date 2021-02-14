package com.zj.videoservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectVO {
    private Long videoId;
    private Long upId;
    private Long fanId;
    private Long favoriteId;
}
