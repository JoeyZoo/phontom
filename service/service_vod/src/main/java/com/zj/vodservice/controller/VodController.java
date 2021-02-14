package com.zj.vodservice.controller;

import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.zj.vodservice.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.zj.baseservice.common.R;

@RestController
@RequestMapping("vodservice")
@Api(tags = "阿里云Vod")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    @PostMapping("/upload")
    @ApiOperation("上传视频到阿里云")
    public R upload(@RequestParam MultipartFile file) {
        UploadStreamResponse response = vodService.uploadVideo(file);
        return R.ok().data("videoSourceId", response.getVideoId())
                .data("response", response);
    }

    @GetMapping("/playInfo/{videoId}")
    @ApiOperation("获取视频播放地址")
    public R getPlayInfo(@PathVariable String videoId) {
        GetPlayInfoResponse playInfo = vodService.getPlayInfo(videoId);
        return R.ok().data("playUrl", playInfo.getPlayInfoList().get(0).getPlayURL())
                .data("cover", playInfo.getVideoBase().getCoverURL())
                .data("playInfo", playInfo);
    }

    @GetMapping("/videoPlayAuth/{videoId}")
    @ApiOperation("获取视频播放凭证")
    public R getVideoPlayAuth(@PathVariable String videoId) {
        GetVideoPlayAuthResponse videoPlayAuth = vodService.getVideoPlayAuth(videoId);
        return R.ok().data("videoPlayAuth", videoPlayAuth.getPlayAuth())
                .data("cover", videoPlayAuth.getVideoMeta().getCoverURL())
                .data("videoMeta", videoPlayAuth.getVideoMeta())
                .data("requestId", videoPlayAuth.getRequestId());
    }

    @DeleteMapping("/{videoId}")
    @ApiOperation("从阿里云删除视频")
    public R deleteVideo(@PathVariable String videoId) {
        vodService.deleteVideo(videoId);
        return R.ok().message("阿里云视频删除成功");
    }
}
