package com.zj.videoservice.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewVideoVO {
    private String title;
    private String description;
    private String cover;
    private String videoSourceId;
    private String videoOriginalName;
    private Long upId;
}
