package com.zj.videoservice.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayRecordVO {
    private Long videoId;
    private Long upId;
    private Long fanId;
}
