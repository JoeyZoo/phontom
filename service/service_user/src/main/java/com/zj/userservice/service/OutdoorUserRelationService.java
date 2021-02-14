package com.zj.userservice.service;

import com.zj.userservice.entity.OutdoorUserRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.userservice.entity.vo.RelationVO;

import java.util.List;

/**
 * <p>
 * 用户关系表 服务类
 * </p>
 *
 * @author zj
 * @since 2020-12-06
 */
public interface OutdoorUserRelationService extends IService<OutdoorUserRelation> {

    // 查询用户关系表是否存在用户粉丝关系
    Integer queryIsFan(RelationVO relationVo);

    // 新增关注
    Integer insertFollow(RelationVO relationVo);

    // 取消关注
    Integer cancelFollow(RelationVO relationVo);

    // 激活关注
    Integer activatingFollow(RelationVO relationVo);

    // 取消关注B
    Integer cancelFollowB(RelationVO relationVo);

    // 激活关注B
    Integer activatingFollowB(RelationVO relationVo);

    // 根据upId查询所有粉丝id
    List<OutdoorUserRelation> queryAllFanId(Long upId);

}
