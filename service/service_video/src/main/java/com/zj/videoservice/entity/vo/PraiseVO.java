package com.zj.videoservice.entity.vo;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PraiseVO {
    private Long sourceId;
    private Integer source;
    private Long fanId;
    private Long upId;
}
