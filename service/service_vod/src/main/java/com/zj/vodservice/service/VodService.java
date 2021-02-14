package com.zj.vodservice.service;

import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import org.springframework.web.multipart.MultipartFile;

public interface VodService {

  // 上传视频到阿里云
  UploadStreamResponse uploadVideo(MultipartFile file);

  // 获取视频播放信息
  GetPlayInfoResponse getPlayInfo(String videoId);

  // 获取视频播放凭证
  GetVideoPlayAuthResponse getVideoPlayAuth(String videoId);

  // 删除阿里云视频
  void deleteVideo(String videoId);
}
