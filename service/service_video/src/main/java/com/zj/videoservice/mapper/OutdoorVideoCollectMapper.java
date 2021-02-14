package com.zj.videoservice.mapper;

import com.zj.videoservice.entity.OutdoorVideoCollect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.videoservice.entity.vo.UpTotalDataVO;
import com.zj.videoservice.entity.vo.VideoVO;

/**
 * <p>
 * 收藏视频表 Mapper 接口
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
public interface OutdoorVideoCollectMapper extends BaseMapper<OutdoorVideoCollect> {

    // 根据视频id查询视频收藏数
    VideoVO countCollectNum(Long id);

    // 根据upId查询其作品总收藏数
    UpTotalDataVO countTotalCollectNum(Long upId);
}
