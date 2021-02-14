package com.zj.videoservice.controller;


import com.zj.baseservice.common.R;
import com.zj.videoservice.entity.vo.NewUpdateVO;
import com.zj.videoservice.entity.vo.UpdateVO;
import com.zj.videoservice.service.OutdoorVideoUpdateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * UP主动态通知表 前端控制器
 * </p>
 *
 * @author zj
 * @since 2021-01-11
 */
@RestController
@RequestMapping("/videoservice/update")
@CrossOrigin
public class OutdoorVideoUpdateController {

    @Autowired
    private OutdoorVideoUpdateService updateService;

    @GetMapping("/queryUpdate/{fanId}")
    @ApiOperation("查询用户关注的UP主动态")
    public R queryUpdate(@PathVariable Long fanId) {
        List<UpdateVO> updateList = updateService.listUpdates(fanId);
        return R.ok().data("updateList", updateList);
    }

    @GetMapping("/updateChecked/{fanId}")
    @ApiOperation("将动态设为已查阅")
    public R updateChecked(@PathVariable Long fanId) {
        updateService.updateChecked(fanId);
        return R.ok();
    }

    @PostMapping("/addUpdate")
    @ApiOperation("查询Up所有粉丝并通知动态")
    public R addUpdate(@RequestBody NewUpdateVO newUpdateVo) {
        updateService.insertUpdate(newUpdateVo);
        return R.ok();
    }
}

