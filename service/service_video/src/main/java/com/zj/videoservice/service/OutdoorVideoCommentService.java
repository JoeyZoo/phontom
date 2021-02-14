package com.zj.videoservice.service;

import com.zj.videoservice.entity.OutdoorVideoComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.videoservice.entity.vo.CommentVO;
import com.zj.videoservice.entity.vo.NewCommentVO;

import java.util.List;

/**
 * <p>
 * 视频评论表 服务类
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
public interface OutdoorVideoCommentService extends IService<OutdoorVideoComment> {

    // 增加视频新评论
    void insertComment(NewCommentVO newCommentVo);

    // 根据评论id删除用户自己发表的评论内容
    void updateComment(Long id);
}
