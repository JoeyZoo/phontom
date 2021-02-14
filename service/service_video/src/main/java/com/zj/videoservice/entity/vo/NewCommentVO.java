package com.zj.videoservice.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCommentVO {
    private Long pid;
    private String content;
    private Long uid;
    private Long videoId;
}
