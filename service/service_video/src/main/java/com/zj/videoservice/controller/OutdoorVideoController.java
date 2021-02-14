package com.zj.videoservice.controller;


import com.zj.baseservice.common.R;
import com.zj.videoservice.entity.OutdoorVideo;
import com.zj.videoservice.entity.vo.*;
import com.zj.videoservice.service.OutdoorVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 视频信息表 前端控制器
 * </p>
 *
 * @author zj
 * @since 2020-12-06
 */
@RestController
@RequestMapping("/videoservice/video")
@Api(tags = "视频接口")
@CrossOrigin
public class OutdoorVideoController {

    @Autowired
    private OutdoorVideoService outdoorVideoService;

    @GetMapping("/findAll/{upId}")
    @ApiOperation("查询某个up所有的作品")
    public R findUpAllVideo(@PathVariable Long upId) {
        List<VideoVO> videoList = outdoorVideoService.listUpAllVideos(upId);
        return R.ok().data("videoList", videoList);
    }

    @GetMapping("/findAll")
    @ApiOperation("分页查询所有视频")
    public R findAllVideo() {
        List<VideoVO> videoList = outdoorVideoService.listAllVideos();
        return R.ok().data("videoList", videoList);
    }

    @GetMapping("/queryLatestRecommand/{current}/{size}")
    @ApiOperation("最新推荐")
    public R queryLatestRecommand(@PathVariable Long current, @PathVariable Long size) {
        List<VideoVO> videoList = outdoorVideoService.listLatestRecommands(current, size);
        return R.ok().data("videoList", videoList);
    }

    @GetMapping("/showSlide")
    @ApiOperation("幻灯片")
    public R showSlide() {
        List<VideoVO> slideList = outdoorVideoService.listSlides();
        return R.ok().data("slideList", slideList);
    }

    @GetMapping("/countVideoTotal")
    @ApiOperation("统计视频条数")
    public R countVideoTotal() {
        Integer total = outdoorVideoService.countVideoTotal();
        return R.ok().data("total", total);
    }

    @GetMapping("/findUpData/{upId}")
    @ApiOperation("根据upId查询用户行为数据总数")
    public R queryUpTotalData(@PathVariable Long upId) {
        UpTotalDataVO totalData = outdoorVideoService.countUpTotalData(upId);
        if (totalData != null) {
            return R.ok().data("totalData", totalData);
        } else {
            return R.error().message("获取用户行为数据失败");
        }
    }

    @PostMapping("/addVideo")
    @ApiOperation("添加视频")
    public R addVideo(@RequestBody NewVideoVO videoVo) {
        outdoorVideoService.insertVideo(videoVo);
        return R.ok();
    }

    @PutMapping("/deleteByLogic/{id}")
    @ApiOperation("逻辑删除视频")
    public R deleteByLogic(@PathVariable Long id) {
        int i = outdoorVideoService.deleteByLogic(id);
        if (i>0) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("删除失败");
        }
    }

    @PostMapping("/findVideoByCondition")
    @ApiOperation("模糊查询")
    public R findVideoByCondition(@RequestBody VideoQueryVO videoQueryVo) {
        List<VideoVO> videoList = outdoorVideoService.listVideosByCondition(videoQueryVo);
        if (videoList == null) {
            return R.error().message("找不到对应的视频作品...");
        } else {
            return R.ok().data("videoList", videoList);
        }
    }

    @GetMapping("/findVideoBySourceId/{videoSourceId}")
    @ApiOperation("根据云端视频id查找视频")
    public R findVideoBySourceId(@PathVariable String videoSourceId) {
        VideoPlayVO video = outdoorVideoService.getVideoBySourceId(videoSourceId);
        return R.ok().data("video", video);
    }
}

