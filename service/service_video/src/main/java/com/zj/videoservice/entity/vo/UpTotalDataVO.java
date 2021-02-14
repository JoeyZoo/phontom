package com.zj.videoservice.entity.vo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpTotalDataVO {
    private Long upId;// up主id
    private Integer totalPlayNum;// 总播放数
    private Integer totalPraiseNum;// 总获赞数
    private Integer totalCollectNum;// 总被收藏数
    private Integer fanNum;// 粉丝数
    private Integer followNum;// 关注他人数
}
