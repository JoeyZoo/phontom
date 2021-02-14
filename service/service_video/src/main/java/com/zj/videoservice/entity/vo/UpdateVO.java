package com.zj.videoservice.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVO {
    private String videoSourceId;
    private String title;// 作品标题
    private String avatar;// 作者头像
    private String nickname;// 作者昵称
    private String cover;// 作品封面
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "Asia/Shanghai")
    private Date gmtCreate;// 动态通知时间,update表
}
