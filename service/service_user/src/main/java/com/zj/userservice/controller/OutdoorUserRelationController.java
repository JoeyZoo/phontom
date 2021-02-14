package com.zj.userservice.controller;


import com.zj.baseservice.common.R;
import com.zj.userservice.entity.OutdoorUserRelation;
import com.zj.userservice.entity.vo.RelationVO;
import com.zj.userservice.service.OutdoorUserRelationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户关系表 前端控制器
 * </p>
 *
 * @author zj
 * @since 2020-12-06
 */
@RestController
@RequestMapping("/userservice/relation")
@CrossOrigin
public class OutdoorUserRelationController {

    @Autowired
    private OutdoorUserRelationService relationService;


    @PostMapping("/queryIsFan")
    @ApiOperation("查询是否存在粉丝关系")
    public R queryIsFan(@RequestBody RelationVO relationVo) {
        Integer fanFlag = relationService.queryIsFan(relationVo);
        return R.ok().data("fanFlag", fanFlag);
    }

    @PostMapping("/addFollow")
    public R addFollow(@RequestBody RelationVO relationVo) {
        Integer fanFlag = relationService.insertFollow(relationVo);
        return R.ok().data("fanFlag", fanFlag);
    }

    @PostMapping("/cancelFollow")
    @ApiOperation("取关")
    public R cancelFollow(@RequestBody RelationVO relationVo) {
        Integer fanFlag = relationService.cancelFollow(relationVo);
        return R.ok().data("fanFlag", fanFlag);
    }

    @PostMapping("/activatingFollow")
    @ApiOperation("激活关注")
    public R activatingFollow(@RequestBody RelationVO relationVo) {
        Integer fanFlag = relationService.activatingFollow(relationVo);
        return R.ok().data("fanFlag", fanFlag);
    }

    @PostMapping("/cancelFollowB")
    @ApiOperation("取关B")
    public R cancelFollowB(@RequestBody RelationVO relationVo) {
        Integer fanFlag = relationService.cancelFollowB(relationVo);
        return R.ok().data("fanFlag", fanFlag);
    }

    @PostMapping("/activatingFollowB")
    @ApiOperation("激活关注B")
    public R activatingFollowB(@RequestBody RelationVO relationVo) {
        Integer fanFlag = relationService.activatingFollowB(relationVo);
        return R.ok().data("fanFlag", fanFlag);
    }

    @GetMapping("/queryAllFanId/{upId}")
    @ApiOperation("根据upId查询所有粉丝id")
    public List<OutdoorUserRelation> queryAllFanId(@PathVariable Long upId) {
        List<OutdoorUserRelation> fanList = relationService.queryAllFanId(upId);
        return fanList;
    }
}

