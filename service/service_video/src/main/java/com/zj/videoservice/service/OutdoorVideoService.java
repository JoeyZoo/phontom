package com.zj.videoservice.service;

import com.zj.baseservice.common.R;
import com.zj.videoservice.entity.OutdoorVideo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.videoservice.entity.vo.*;

import java.util.List;

/**
 * <p>
 * 视频信息表 服务类
 * </p>
 *
 * @author zj
 * @since 2020-12-06
 */
public interface OutdoorVideoService extends IService<OutdoorVideo> {

    // 根据云端视频id查找视频信息
    VideoPlayVO getVideoBySourceId(String videoSourceId);

    // 查询某个up主所有的视频
    List<VideoVO> listUpAllVideos(Long upId);

    // 统计up主数据
    UpTotalDataVO countUpTotalData(Long upId);

    // 根据upId查询up的粉丝数量
    Integer countFanNum(Long upId);

    // 根据upId查询up的粉丝数量
    Integer countFollowNum(Long upId);

    // 查询所有视频
    List<VideoVO> listAllVideos();

    // 最新推荐
    List<VideoVO> listLatestRecommands(Long current, Long size);

    // 幻灯片
    List<VideoVO> listSlides();

    // 统计视频条数
    Integer countVideoTotal();

    // 添加视频
    R insertVideo(NewVideoVO videoVo);

    // 根据视频id（不是阿里云视频id）逻辑删除视频
    int deleteByLogic(Long id);

    // 条件查询up作品
    List<VideoVO> listVideosByCondition(VideoQueryVO videoQueryVo);
}
