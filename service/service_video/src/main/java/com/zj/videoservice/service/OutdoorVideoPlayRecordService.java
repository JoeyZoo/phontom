package com.zj.videoservice.service;

import com.zj.videoservice.entity.OutdoorVideoPlayRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.videoservice.entity.vo.PlayRecordVO;

/**
 * <p>
 * 播放历史表 服务类
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
public interface OutdoorVideoPlayRecordService extends IService<OutdoorVideoPlayRecord> {

    // 统计某视频播放数
    Integer countPlayNum(Long id);

    // 根据upId查询其作品总播放数
    Integer countTotalPlayNum(Long upId);

    // 添加一条播放记录并查询当前播放数
    Integer insertPlayRecord(PlayRecordVO playRecordVo);

}
