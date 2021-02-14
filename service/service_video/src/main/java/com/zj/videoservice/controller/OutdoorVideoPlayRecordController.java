package com.zj.videoservice.controller;


import com.zj.baseservice.common.R;
import com.zj.videoservice.entity.vo.PlayHistoryVO;
import com.zj.videoservice.entity.vo.PlayRecordVO;
import com.zj.videoservice.mapper.OutdoorVideoPlayRecordMapper;
import com.zj.videoservice.service.OutdoorVideoPlayRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 播放历史表 前端控制器
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/videoservice/playRecord")
@CrossOrigin
public class OutdoorVideoPlayRecordController {

    @Autowired
    private OutdoorVideoPlayRecordService playRecordService;

    @Autowired
    private OutdoorVideoPlayRecordMapper playRecordMapper;

    @PostMapping("/addPlayRecord")
    @ApiOperation("添加播放记录并返回视频总播放数")
    public R addPlayRecord(@RequestBody PlayRecordVO playRecordVo) {
        Integer newPlayNum = playRecordService.insertPlayRecord(playRecordVo);
        return R.ok().data("newPlayNum", newPlayNum);
    }

    @GetMapping("/queryPlayHistory/{fanId}")
    @ApiOperation("查询用户历史播放记录")
    public R queryPlayHistory(@PathVariable Long fanId) {
        List<PlayHistoryVO> playHistoryList = playRecordMapper.listPlayHistorys(fanId);
        return R.ok().data("playHistoryList", playHistoryList);
    }
}

