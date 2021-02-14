package com.zj.videoservice.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoQueryVO {
    private String titleKeyword;
    private Long upId;
}
