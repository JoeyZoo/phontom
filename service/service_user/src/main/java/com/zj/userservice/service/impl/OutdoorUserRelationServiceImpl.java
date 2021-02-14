package com.zj.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.userservice.entity.OutdoorUserRelation;
import com.zj.userservice.entity.vo.RelationVO;
import com.zj.userservice.mapper.OutdoorUserRelationMapper;
import com.zj.userservice.service.OutdoorUserRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户关系表 服务实现类
 * </p>
 *
 * @author zj
 * @since 2020-12-06
 */
@Service
public class OutdoorUserRelationServiceImpl extends ServiceImpl<OutdoorUserRelationMapper, OutdoorUserRelation> implements OutdoorUserRelationService {


    // 共用Wrapper对象
    private QueryWrapper<OutdoorUserRelation> common(RelationVO relationVo) {
        QueryWrapper<OutdoorUserRelation> relationWrapper = new QueryWrapper<>();
        relationWrapper.eq("up_id", relationVo.getUpId());
        relationWrapper.eq("fan_id", relationVo.getFanId());
        return relationWrapper;
    }

    OutdoorUserRelation relation = new OutdoorUserRelation();

    public void cancel(RelationVO relationVo) {
        relation.setIsDeleted(true);
        timeModifyAndUpdate(relationVo);
    }

    public void activating(RelationVO relationVo) {
        relation.setIsDeleted(false);
        timeModifyAndUpdate(relationVo);
    }

    public void timeModifyAndUpdate(RelationVO relationVo) {
        relation.setGmtModified(new Date());
        baseMapper.update(relation, common(relationVo));
    }

    @Override
    public Integer queryIsFan(RelationVO relationVo) {
        OutdoorUserRelation userRelation = baseMapper.selectOne(common(relationVo));
        if (userRelation!=null) {//用户关注过该up
            if (userRelation.getIsDeleted()) {//用户已取关
                return 0;
            } else {
                return 1;//关注状态正常
            }
        } else {//用户从未关注过该up
            return 2;
        }
    }

    @Override
    public Integer insertFollow(RelationVO relationVo) {
        OutdoorUserRelation relation1 = new OutdoorUserRelation();
        relation1.setFanId(relationVo.getFanId());
        relation1.setUpId(relationVo.getUpId());
        relation1.setGmtCreate(new Date());
        relation1.setGmtModified(new Date());
        relation1.setIsDeleted(false);
        baseMapper.insert(relation1);
        return 3;
    }

    @Override
    public Integer cancelFollow(RelationVO relationVo) {
        cancel(relationVo);
        return 0;
    }

    @Override
    public Integer activatingFollow(RelationVO relationVo) {
        activating(relationVo);
        return 3;
    }

    @Override
    public Integer cancelFollowB(RelationVO relationVo) {
        cancel(relationVo);
        return 4;
    }

    @Override
    public Integer activatingFollowB(RelationVO relationVo) {
        activating(relationVo);
        return 1;
    }

    @Override
    public List<OutdoorUserRelation> queryAllFanId(Long upId) {
        QueryWrapper<OutdoorUserRelation> relationWrapper = new QueryWrapper<>();
        relationWrapper.eq("up_id", upId);
        relationWrapper.eq("is_deleted", 0);
        List<OutdoorUserRelation> fanList = baseMapper.selectList(relationWrapper);
        return fanList;
    }
}
