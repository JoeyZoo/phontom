package com.zj.videoservice.mapper;

import com.zj.videoservice.entity.OutdoorPraise;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.videoservice.entity.vo.CommentVO;
import com.zj.videoservice.entity.vo.UpTotalDataVO;
import com.zj.videoservice.entity.vo.VideoVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
public interface OutdoorPraiseMapper extends BaseMapper<OutdoorPraise> {

    // 根据upId查询总获赞数
    UpTotalDataVO countTotalPraiseNum(Long upId);

    // 统计某视频获赞数，截止当前时间
    VideoVO countPraiseNum(Long id);
}
