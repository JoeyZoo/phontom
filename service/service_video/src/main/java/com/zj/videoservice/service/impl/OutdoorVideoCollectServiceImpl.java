package com.zj.videoservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.videoservice.entity.OutdoorVideoCollect;
import com.zj.videoservice.entity.vo.CollectVO;
import com.zj.videoservice.entity.vo.UpTotalDataVO;
import com.zj.videoservice.entity.vo.VideoVO;
import com.zj.videoservice.mapper.OutdoorVideoCollectMapper;
import com.zj.videoservice.service.OutdoorVideoCollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 收藏视频表 服务实现类
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@Service
public class OutdoorVideoCollectServiceImpl extends ServiceImpl<OutdoorVideoCollectMapper, OutdoorVideoCollect> implements OutdoorVideoCollectService {

    @Autowired
    private OutdoorVideoCollectMapper collectMapper;

    private QueryWrapper<OutdoorVideoCollect> common(CollectVO collectVo) {
        QueryWrapper<OutdoorVideoCollect> collectWrapper = new QueryWrapper<>();
        collectWrapper.eq("fan_id", collectVo.getFanId());
        collectWrapper.eq("video_id", collectVo.getVideoId());
        return collectWrapper;
    }

    OutdoorVideoCollect collect = new OutdoorVideoCollect();

    public void cancel(CollectVO collectVo) {
        collect.setIsDeleted(true);// 失效
        timeModifyAndUpdate(collectVo);
    }

    public void activating(CollectVO collectVo) {
        collect.setIsDeleted(false);// 激活
        timeModifyAndUpdate(collectVo);
    }

    public void timeModifyAndUpdate(CollectVO collectVo) {
        collect.setGmtModified(new Date());
        baseMapper.update(collect, common(collectVo));
    }

    @Override
    public int countCollectNum(Long id) {
        VideoVO videoVo = collectMapper.countCollectNum(id);
        int collectNum = videoVo.getCollectNum();
        return collectNum;
    }

    @Override
    public int countTotalCollectNum(Long upId) {
        UpTotalDataVO totalData = collectMapper.countTotalCollectNum(upId);
        int totalCollectNum = totalData.getTotalCollectNum();
        return totalCollectNum;
    }

    @Override
    public int queryIsCollected(CollectVO collectVo) {
        OutdoorVideoCollect one = baseMapper.selectOne(common(collectVo));
        if (one != null) {// 用户收藏过该视频，但不确定收藏状态
            if (one.getIsDeleted()) {// 收藏失效
                return 0;
            } else {
                return 1;// 收藏状态正常
            }
        } else {// 从未收藏过该视频
            return 2;
        }
    }

    @Override
    public int activatingCollect(CollectVO collectVo) {
        activating(collectVo);
        return 3;
    }

    @Override
    public int cancelCollect(CollectVO collectVo) {
       cancel(collectVo);
        return 0;
    }

    @Override
    public int activatingCollectB(CollectVO collectVo) {
        activating(collectVo);
        return 1;
    }

    @Override
    public int cancelCollectB(CollectVO collectVo) {
        cancel(collectVo);
        return 4;
    }

    @Override
    public int insertCollect(CollectVO collectVo) {
        OutdoorVideoCollect collect1 = new OutdoorVideoCollect();
        collect1.setVideoId(collectVo.getVideoId());
        collect1.setFanId(collectVo.getFanId());
        collect1.setUpId(collectVo.getUpId());
        collect1.setIsDeleted(false);
        collect1.setGmtCreate(new Date());
        collect1.setGmtModified(new Date());
        baseMapper.insert(collect1);
        return 3;
    }
}
