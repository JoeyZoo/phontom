package com.zj.videoservice.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentFlagVO {
    private Long videoId;// 评论所属视频id
    private Long fanId;// 登录用户的id
}
