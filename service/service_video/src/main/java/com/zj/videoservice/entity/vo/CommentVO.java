package com.zj.videoservice.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {
    private Long id;
    private Long uid;
    private String nickname;
    private String avatar;
    private String content;//评论内容
    private Integer praiseNum;//评论获赞数
    private Long fanId;//登录用户点赞标记
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "Asia/Shanghai")
    private Date gmtCreate;
}
