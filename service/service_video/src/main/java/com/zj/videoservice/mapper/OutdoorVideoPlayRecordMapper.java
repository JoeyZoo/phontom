package com.zj.videoservice.mapper;

import com.zj.videoservice.entity.OutdoorVideoPlayRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.videoservice.entity.vo.PlayHistoryVO;
import com.zj.videoservice.entity.vo.PlayRecordVO;
import com.zj.videoservice.entity.vo.UpTotalDataVO;
import com.zj.videoservice.entity.vo.VideoVO;

import java.util.List;

/**
 * <p>
 * 播放历史表 Mapper 接口
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
public interface  OutdoorVideoPlayRecordMapper extends BaseMapper<OutdoorVideoPlayRecord> {

    // 根据视频id统计播放数
    VideoVO countPlayNum(Long id);

    // 根据upId查询其作品总播放数
    UpTotalDataVO countTotalPlayNum(Long upId);

    // 查询用户历史播放记录
    List<PlayHistoryVO> listPlayHistorys(Long fanId);
}
