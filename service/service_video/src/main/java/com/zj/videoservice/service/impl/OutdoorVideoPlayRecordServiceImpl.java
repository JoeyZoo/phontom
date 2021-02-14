package com.zj.videoservice.service.impl;

import com.zj.baseservice.common.OutdoorException;
import com.zj.videoservice.entity.OutdoorVideoPlayRecord;
import com.zj.videoservice.entity.vo.PlayRecordVO;
import com.zj.videoservice.entity.vo.UpTotalDataVO;
import com.zj.videoservice.entity.vo.VideoVO;
import com.zj.videoservice.mapper.OutdoorVideoPlayRecordMapper;
import com.zj.videoservice.service.OutdoorVideoPlayRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 播放历史表 服务实现类
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@Service
public class OutdoorVideoPlayRecordServiceImpl extends ServiceImpl<OutdoorVideoPlayRecordMapper, OutdoorVideoPlayRecord> implements OutdoorVideoPlayRecordService {

    @Autowired
    private OutdoorVideoPlayRecordMapper playRecordMapper;

    @Override
    public Integer countPlayNum(Long id) {
        VideoVO videoVo = playRecordMapper.countPlayNum(id);
        Integer playNum = videoVo.getPlayNum();
        return playNum;
    }

    @Override
    public Integer countTotalPlayNum(Long upId) {
        UpTotalDataVO totalData = playRecordMapper.countTotalPlayNum(upId);
        Integer totalPlayNum = totalData.getTotalPlayNum();
        return totalPlayNum;
    }

    @Override
    public Integer insertPlayRecord(PlayRecordVO playRecordVo) {
        OutdoorVideoPlayRecord playRecord = new OutdoorVideoPlayRecord();
        playRecord.setVideoId(playRecordVo.getVideoId());
        playRecord.setFanId(playRecordVo.getFanId());
        playRecord.setUpId(playRecordVo.getUpId());
        playRecord.setGmtCreate(new Date());
        playRecord.setGmtModified(new Date());
        int i = baseMapper.insert(playRecord);
        if (i>0) {// 添加播放记录成功，查询视频当前播放量并返回
            Integer newPlayNum = countPlayNum(playRecordVo.getVideoId());
            return newPlayNum;
        } else {
            throw new OutdoorException("添加视频播放记录失败", 20001);
        }
    }
}
