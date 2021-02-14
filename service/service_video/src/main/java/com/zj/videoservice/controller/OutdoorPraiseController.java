package com.zj.videoservice.controller;


import com.zj.baseservice.common.R;
import com.zj.videoservice.entity.vo.PraiseVO;
import com.zj.videoservice.service.OutdoorPraiseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/videoservice/praise")
@CrossOrigin
public class OutdoorPraiseController {

    @Autowired
    private OutdoorPraiseService outdoorPraiseService;

    @PostMapping("/queryIsPraised")
    @ApiOperation("查询用户是否已点赞视频")
    public R queryIsPraised(@RequestBody PraiseVO praiseVo) {
        int praiseFlag = outdoorPraiseService.queryIsPraised(praiseVo);
        return R.ok().data("praiseFlag", praiseFlag);
    }

    @PostMapping("/addPraise")
    @ApiOperation("添加赞")
    public R addPraise(@RequestBody PraiseVO praiseVo) {
        int praiseFlag = outdoorPraiseService.insertPraise(praiseVo);
        return R.ok().data("praiseFlag", praiseFlag);
    }

    @PostMapping("/activatingPraise")
    @ApiOperation("激活赞")
    public R activatingPraise(@RequestBody PraiseVO praiseVo) {
        int praiseFlag = outdoorPraiseService.activatingPraise(praiseVo);
        return R.ok().data("praiseFlag", praiseFlag);
    }

    @PostMapping("/activatingPraiseB")
    @ApiOperation("激活赞B")
    public R activatingPraiseB(@RequestBody PraiseVO praiseVo) {
        int praiseFlag = outdoorPraiseService.activatingPraiseB(praiseVo);
        return R.ok().data("praiseFlag", praiseFlag);
    }

    @PostMapping("/cancelPraise")
    @ApiOperation("取消赞")
    public R cancelPraise(@RequestBody PraiseVO praiseVo) {
        int praiseFlag = outdoorPraiseService.cancelPraise(praiseVo);
        return R.ok().data("praiseFlag", praiseFlag);
    }

    @PostMapping("/cancelPraiseB")
    @ApiOperation("取消赞")
    public R cancelPraiseB(@RequestBody PraiseVO praiseVo) {
        int praiseFlag = outdoorPraiseService.cancelPraiseB(praiseVo);
        return R.ok().data("praiseFlag", praiseFlag);
    }
}

