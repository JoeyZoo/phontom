package com.zj.videoservice.mapper;

import com.zj.videoservice.entity.OutdoorVideoComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.videoservice.entity.vo.CommentFlagVO;
import com.zj.videoservice.entity.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 视频评论表 Mapper 接口
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
public interface OutdoorVideoCommentMapper extends BaseMapper<OutdoorVideoComment> {

    // 某视频一级评论按照发布时间降序
    List<CommentVO> listCommentsOrderByTime(CommentFlagVO commentFlagVO);

    // 某视频一级评论首先按获赞数降序排序，其次按评论时间降序排序
    List<CommentVO> listCommentsOrderByPraise(CommentFlagVO commentFlagVO);
}
