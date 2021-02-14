package com.zj.videoservice.controller;


import com.zj.baseservice.common.R;
import com.zj.videoservice.entity.vo.CollectVO;
import com.zj.videoservice.service.OutdoorVideoCollectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 收藏视频表 前端控制器
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/videoservice/collect")
@CrossOrigin
public class OutdoorVideoCollectController {

    @Autowired
    private OutdoorVideoCollectService collectService;

    @PostMapping("/queryIsCollected")
    @ApiOperation("查询用户是否收藏某视频")
    public R queryIsCollected(@RequestBody CollectVO collectVo) {
        Integer collectFlag = collectService.queryIsCollected(collectVo);
        return R.ok().data("collectFlag", collectFlag);
    }

    @PostMapping("/activatingCollect")
    @ApiOperation("激活收藏")
    public R activatingCollect(@RequestBody CollectVO collectVo) {
        Integer collectFlag = collectService.activatingCollect(collectVo);
        return R.ok().data("collectFlag", collectFlag);
    }

    @PostMapping("/activatingCollectB")
    @ApiOperation("激活收藏B")
    public R activatingCollectB(@RequestBody CollectVO collectVo) {
        Integer collectFlag = collectService.activatingCollectB(collectVo);
        return R.ok().data("collectFlag", collectFlag);
    }

    @PostMapping("/cancelCollect")
    @ApiOperation("使收藏失效")
    public R cancelCollect(@RequestBody CollectVO collectVo) {
        Integer collectFlag = collectService.cancelCollect(collectVo);
        return R.ok().data("collectFlag", collectFlag);
    }
    @PostMapping("/cancelCollectB")
    @ApiOperation("使收藏失效B")
    public R cancelCollectB(@RequestBody CollectVO collectVo) {
        Integer collectFlag = collectService.cancelCollectB(collectVo);
        return R.ok().data("collectFlag", collectFlag);
    }

    @PostMapping("/addCollect")
    @ApiOperation("新增收藏")
    public R addCollect(@RequestBody CollectVO collectVo) {
        Integer collectFlag = collectService.insertCollect(collectVo);
        return R.ok().data("collectFlag", collectFlag);
    }
}

