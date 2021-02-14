package com.zj.videoservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.videoservice.entity.OutdoorPraise;
import com.zj.videoservice.entity.vo.PraiseVO;
import com.zj.videoservice.entity.vo.UpTotalDataVO;
import com.zj.videoservice.entity.vo.VideoVO;
import com.zj.videoservice.mapper.OutdoorPraiseMapper;
import com.zj.videoservice.service.OutdoorPraiseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@Service
public class OutdoorPraiseServiceImpl extends ServiceImpl<OutdoorPraiseMapper, OutdoorPraise> implements OutdoorPraiseService {

    @Autowired
    private OutdoorPraiseMapper outdoorPraiseMapper;

    private QueryWrapper<OutdoorPraise> common(PraiseVO praiseVo) {
        QueryWrapper<OutdoorPraise> praiseWrapper = new QueryWrapper<>();
        praiseWrapper.eq("fan_id", praiseVo.getFanId());
        praiseWrapper.eq("source",praiseVo.getSource());
        praiseWrapper.eq("source_id", praiseVo.getSourceId());
        return praiseWrapper;
    }

    OutdoorPraise outdoorPraise = new OutdoorPraise();

    public void cancel(PraiseVO praiseVo) {
        outdoorPraise.setIsDeleted(true);
        timeModifyAndUpdate(praiseVo);
    }

    public void activating(PraiseVO praiseVo) {
        outdoorPraise.setIsDeleted(false);
        timeModifyAndUpdate(praiseVo);
    }

    public void timeModifyAndUpdate(PraiseVO praiseVo) {
        outdoorPraise.setGmtModified(new Date());
        baseMapper.update(outdoorPraise, common(praiseVo));
    }

    @Override
    public int queryIsPraised(PraiseVO praiseVo) {
        OutdoorPraise one = baseMapper.selectOne(common(praiseVo));
        if (one != null) {// 用户曾经点赞该视频
            Boolean isDeleted = one.getIsDeleted();
            if (isDeleted) {// 但又取消赞，赞失效
                return 0;
            } else {// 未取消赞，赞有效
                return 1;
            }
        } else {// 用户从未点赞过该视频
            return 2;
        }
    }

    // 点过赞，但赞失效，激活赞
    @Override
    public int activatingPraise(PraiseVO praiseVo) {
        activating(praiseVo);
        return 3;
    }

    // 点过赞，但赞失效，激活赞
    @Override
    public int activatingPraiseB(PraiseVO praiseVo) {
        activating(praiseVo);
        return 1;
    }

    // 表明之前没有点赞过该视频,可添加一条新的点赞信息到数据库
    @Override
    public int insertPraise(PraiseVO praiseVo) {
        OutdoorPraise outdoorPraise1 = new OutdoorPraise();
        outdoorPraise1.setSourceId(praiseVo.getSourceId());
        outdoorPraise1.setSource(praiseVo.getSource());
        outdoorPraise1.setFanId(praiseVo.getFanId());
        outdoorPraise1.setUpId(praiseVo.getUpId());
        outdoorPraise1.setGmtCreate(new Date());
        outdoorPraise1.setGmtModified(new Date());
        baseMapper.insert(outdoorPraise1);
        return 3;
    }

    // 取消赞
    @Override
    public int cancelPraise(PraiseVO praiseVo) {
       cancel(praiseVo);
       return 0;
    }

    // 曾经点过赞，赞仍有效，要取消赞
    @Override
    public int cancelPraiseB(PraiseVO praiseVo) {
        cancel(praiseVo);
        return 4;
    }

    @Override
    public int countPraiseNum(Long id) {
        VideoVO videoVo = outdoorPraiseMapper.countPraiseNum(id);
        Integer praiseNum = videoVo.getPraiseNum();
        return praiseNum;
    }

    @Override
    public int countTotalPraiseNum(Long upId) {
        UpTotalDataVO totalData = outdoorPraiseMapper.countTotalPraiseNum(upId);
        Integer totalPraiseNum = totalData.getTotalPraiseNum();
        return totalPraiseNum;
    }
}
