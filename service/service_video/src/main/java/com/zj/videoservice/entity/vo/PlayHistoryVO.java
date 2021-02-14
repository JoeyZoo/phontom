package com.zj.videoservice.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayHistoryVO {
    private Long id;
    private Long fanId;
    private String videoSourceId;
    private String title;
    private String cover;
    private String gmtCreate;
}
