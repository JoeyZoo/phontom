package com.zj.videoservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.baseservice.entity.OutdoorUserRelation;
import com.zj.videoservice.client.UserClient;
import com.zj.videoservice.entity.OutdoorVideoUpdate;
import com.zj.videoservice.entity.vo.NewUpdateVO;
import com.zj.videoservice.entity.vo.UpdateVO;
import com.zj.videoservice.mapper.OutdoorVideoUpdateMapper;
import com.zj.videoservice.service.OutdoorVideoUpdateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * UP主动态通知表 服务实现类
 * </p>
 *
 * @author zj
 * @since 2021-01-11
 */
@Service
public class OutdoorVideoUpdateServiceImpl extends ServiceImpl<OutdoorVideoUpdateMapper, OutdoorVideoUpdate> implements OutdoorVideoUpdateService {

    @Autowired
    private OutdoorVideoUpdateMapper updateMapper;

    @Autowired
    private UserClient userClient;

    @Override
    public List<UpdateVO> listUpdates(Long fanId) {
        QueryWrapper<OutdoorVideoUpdate> updateWrapper = new QueryWrapper<>();
        updateWrapper.eq("fan_id", fanId);
        List<UpdateVO> updateList = updateMapper.listUpdates(fanId);
        return updateList;
    }

    @Override
    public void updateChecked(Long fanId) {
        QueryWrapper<OutdoorVideoUpdate> updateWrapper = new QueryWrapper<>();
        updateWrapper.eq("fan_id", fanId);
        OutdoorVideoUpdate update = new OutdoorVideoUpdate();
        update.setIsDeleted(true);
        update.setGmtModified(new Date());
        baseMapper.update(update, updateWrapper);
    }

    @Override
    public void insertUpdate(NewUpdateVO newUpdateVo) {
        OutdoorVideoUpdate update = new OutdoorVideoUpdate();
        List<OutdoorUserRelation> fanList = userClient.queryAllFanId(newUpdateVo.getUpId());
        update.setUpId(newUpdateVo.getUpId());
        update.setVideoSourceId(newUpdateVo.getVideoSourceId());
        for (OutdoorUserRelation fan : fanList) {
            update.setFanId(fan.getFanId());
            update.setGmtCreate(new Date());
            update.setGmtModified(new Date());
            baseMapper.insert(update);
        }
    }
}
