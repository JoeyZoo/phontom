package com.zj.videoservice.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zj.videoservice.entity.OutdoorVideo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.videoservice.entity.vo.UpTotalDataVO;
import com.zj.videoservice.entity.vo.VideoVO;
import com.zj.videoservice.entity.vo.VideoPlayVO;
import com.zj.videoservice.entity.vo.VideoQueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 视频信息表 Mapper 接口
 * </p>
 *
 * @author zj
 * @since 2020-12-06
 */
@Mapper
public interface OutdoorVideoMapper extends BaseMapper<OutdoorVideo> {

    // 查询up主作品列表
    List<VideoVO> listUpAllVideos(Long upId);

    // up主作品列表条件查询
    List<VideoVO> listVideosByCondition(VideoQueryVO videoQueryVo);

    // 首页查询最新视频
    List<VideoVO> listAllVideos();

    // 幻灯片展示
     List<VideoVO> listSlides();

    // 最新推荐
    IPage<VideoVO> listLatestRecommands(IPage<VideoVO> page);

    // 根据云端视频id查找视频信息
    VideoPlayVO getVideoBySourceId(String videoSourceId);

    // 根据upId查询up的粉丝数量
    UpTotalDataVO countFanNum(Long upId);

    // 根据upId查询up的粉丝数量
    UpTotalDataVO countFollowNum(Long upId);

}
