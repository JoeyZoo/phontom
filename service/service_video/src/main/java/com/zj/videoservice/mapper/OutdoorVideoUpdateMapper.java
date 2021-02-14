package com.zj.videoservice.mapper;

import com.zj.videoservice.entity.OutdoorVideoUpdate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.videoservice.entity.vo.UpdateVO;

import java.util.List;

/**
 * <p>
 * UP主动态通知表 Mapper 接口
 * </p>
 *
 * @author zj
 * @since 2021-01-11
 */
public interface OutdoorVideoUpdateMapper extends BaseMapper<OutdoorVideoUpdate> {

    // 查阅用户关注up的动态
    List<UpdateVO> listUpdates(Long fanId);
}
