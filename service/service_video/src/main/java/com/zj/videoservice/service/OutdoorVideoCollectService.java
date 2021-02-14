package com.zj.videoservice.service;

import com.zj.videoservice.entity.OutdoorVideoCollect;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.videoservice.entity.vo.CollectVO;

/**
 * <p>
 * 收藏视频表 服务类
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
public interface OutdoorVideoCollectService extends IService<OutdoorVideoCollect> {

    // 根据视频id查询视频收藏数
    int countCollectNum(Long id);

    // 根据upId查询其作品总收藏数
    int countTotalCollectNum(Long upId);

    // 查询用户是否收藏某视频
    int queryIsCollected(CollectVO collectVo);

    // 激活收藏
    int activatingCollect(CollectVO collectVo);

    // 取消收藏
    int cancelCollect(CollectVO collectVo);

    // 激活收藏B
    int activatingCollectB(CollectVO collectVo);

    // 取消收藏B
    int cancelCollectB(CollectVO collectVo);

    // 新增收藏
    int insertCollect(CollectVO collectVo);
}
