package com.zj.videoservice.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoVO {
    private Long id;// 作品id
    private String title;// 作品标题
    private String description;// 作品描述
    private String videoSourceId;// 阿里云视频id
    private String typeName;// 作品分类
    private String avatar;// 作者头像
    private String nickname;// 作者昵称
    private String motto;// 作者座右铭
    private String cover;// 作品封面
    private Integer praiseNum;// 作品获赞数
    private Integer playNum;// 作品播放数
    private Integer collectNum;// 作品收藏数
    private Boolean isFree;// 是否免费
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date gmtCreate;// 作品发表时间
}
