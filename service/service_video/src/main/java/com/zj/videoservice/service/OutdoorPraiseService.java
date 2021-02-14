package com.zj.videoservice.service;

import com.zj.videoservice.entity.OutdoorPraise;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.videoservice.entity.vo.PraiseVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
public interface OutdoorPraiseService extends IService<OutdoorPraise> {

    // 添加点赞信息
    int insertPraise(PraiseVO praiseVo);

    // 查询用户是否点赞过某视频
    int queryIsPraised(PraiseVO praiseVo);

    // 点过赞，但赞失效，激活赞
    int activatingPraise(PraiseVO praiseVo);

    int activatingPraiseB(PraiseVO praiseVo);

    // 取消赞
    int cancelPraise(PraiseVO praiseVo);

    // 曾经点过赞，赞仍有效，要取消赞
    int cancelPraiseB(PraiseVO praiseVo);

    // 统计某视频/评论获赞数，截止当前时间
    int countPraiseNum(Long id);

    // 根据upId查询总获赞数
    int countTotalPraiseNum(Long upId);


}
