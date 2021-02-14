package com.zj.videoservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zj.baseservice.common.R;
import com.zj.videoservice.entity.OutdoorVideo;
import com.zj.videoservice.entity.vo.*;
import com.zj.videoservice.mapper.OutdoorVideoMapper;
import com.zj.videoservice.service.OutdoorPraiseService;
import com.zj.videoservice.service.OutdoorVideoCollectService;
import com.zj.videoservice.service.OutdoorVideoPlayRecordService;
import com.zj.videoservice.service.OutdoorVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 视频信息表 服务实现类
 * </p>
 *
 * @author zj
 * @since 2020-12-06
 */
@Service
public class OutdoorVideoServiceImpl extends ServiceImpl<OutdoorVideoMapper, OutdoorVideo> implements OutdoorVideoService {

    @Autowired
    private OutdoorVideoMapper outdoorVideoMapper;

    @Autowired
    private OutdoorVideoPlayRecordService playRecordService;

    @Autowired
    private OutdoorVideoCollectService collectService;

    @Autowired
    private OutdoorPraiseService outdoorPraiseService;

    @Override
    public VideoPlayVO getVideoBySourceId(String videoSourceId) {
        VideoPlayVO video = outdoorVideoMapper.getVideoBySourceId(videoSourceId);
        video.setPlayNum(playRecordService.countPlayNum(video.getId()));
        video.setCollectNum(collectService.countCollectNum(video.getId()));
        video.setPraiseNum(outdoorPraiseService.countPraiseNum(video.getId()));
        video.setFanNum(countFanNum(video.getUpId()));
        return video;
    }

    @Override
    public List<VideoVO> listUpAllVideos(Long upId) {
        List<VideoVO> videoList = outdoorVideoMapper.listUpAllVideos(upId);
        for (int i = 0; i < videoList.size(); i++) {
            VideoVO videoVo = videoList.get(i);
            videoVo.setPraiseNum(outdoorPraiseService.countPraiseNum(videoVo.getId()));
            videoVo.setPlayNum(playRecordService.countPlayNum( videoVo.getId()));
            videoVo.setCollectNum(collectService.countCollectNum(videoVo.getId()));
        }
        return videoList;
    }

    @Override
    public UpTotalDataVO countUpTotalData(Long upId) {
        UpTotalDataVO totalData = new UpTotalDataVO();
        totalData.setUpId(upId);
        totalData.setTotalPraiseNum(outdoorPraiseService.countTotalPraiseNum(upId));
        totalData.setTotalPlayNum(playRecordService.countTotalPlayNum(upId));
        totalData.setTotalCollectNum(collectService.countTotalCollectNum(upId));
        totalData.setFanNum(countFanNum(upId));
        totalData.setFollowNum(countFollowNum(upId));
        return totalData;
    }

    @Override
    public Integer countFanNum(Long upId) {
        UpTotalDataVO totalData = outdoorVideoMapper.countFanNum(upId);
        Integer fanNum = totalData.getFanNum();
        return fanNum;
    }

    @Override
    public Integer countFollowNum(Long upId) {
        UpTotalDataVO totalData = outdoorVideoMapper.countFollowNum(upId);
        Integer followNum = totalData.getFollowNum();
        return followNum;
    }

    @Override
    public List<VideoVO> listAllVideos() {
        List<VideoVO> videoList = outdoorVideoMapper.listAllVideos();
        for (int i = 0; i < videoList.size(); i++) {
            VideoVO videoVo = videoList.get(i);
            videoVo.setPraiseNum(outdoorPraiseService.countPraiseNum(videoVo.getId()));
            videoVo.setPlayNum(playRecordService.countPlayNum(videoVo.getId()));
            videoVo.setCollectNum(collectService.countCollectNum(videoVo.getId()));
        }
        return videoList;
    }

    @Override
    public List<VideoVO> listLatestRecommands(Long current, Long size) {
        Page<VideoVO> page = new Page<>(current, size);
        IPage<VideoVO> videoVoIPage = outdoorVideoMapper.listLatestRecommands(page);
        List<VideoVO> videoList = videoVoIPage.getRecords();
        return videoList;
    }

    @Override
    public List<VideoVO> listSlides() {
        return outdoorVideoMapper.listSlides();
    }

    @Override
    public Integer countVideoTotal() {
        QueryWrapper<OutdoorVideo> videoWrapper = new QueryWrapper<>();
        videoWrapper.eq("is_deleted", 0);
        Integer count = baseMapper.selectCount(videoWrapper);
        return count;
    }

    @Override
    public R insertVideo(NewVideoVO videoVo) {
        String title = videoVo.getTitle();//50字标题
        String cover = videoVo.getCover();
        String description = videoVo.getDescription();//250字介绍
        String videoOriginalName = videoVo.getVideoOriginalName();
        String videoSourceId = videoVo.getVideoSourceId();
        Long upId = videoVo.getUpId();
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(cover) || StringUtils.isEmpty(description) || StringUtils.isEmpty(videoOriginalName) ||
                StringUtils.isEmpty(videoSourceId)) {
            return R.error().message("作品信息未填写完整");
        }
        OutdoorVideo outdoorVideo = new OutdoorVideo();
        outdoorVideo.setTitle(title);
        outdoorVideo.setCover(cover);
        outdoorVideo.setDescription(description);
        outdoorVideo.setUpId(upId);
        outdoorVideo.setVideoSourceId(videoSourceId);
        outdoorVideo.setVideoOriginalName(videoOriginalName);
        outdoorVideo.setGmtCreate(new Date());
        outdoorVideo.setGmtModified(new Date());
        baseMapper.insert(outdoorVideo);
        return R.ok();
    }

    @Override
    public int deleteByLogic(Long id) {
        QueryWrapper<OutdoorVideo> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.eq("id", id);
        OutdoorVideo outdoorVideo = new OutdoorVideo();
        outdoorVideo.setIsDeleted(true);
        int i = baseMapper.update(outdoorVideo, videoQueryWrapper);
       return i;
    }

    @Override
    public List<VideoVO> listVideosByCondition(VideoQueryVO videoQueryVo) {
        List<VideoVO> videoList = outdoorVideoMapper.listVideosByCondition(videoQueryVo);
        return videoList;
    }
}
