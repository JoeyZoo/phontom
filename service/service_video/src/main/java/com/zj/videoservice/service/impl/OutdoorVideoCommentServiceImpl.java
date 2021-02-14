package com.zj.videoservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.videoservice.entity.OutdoorVideoComment;
import com.zj.videoservice.entity.vo.CommentVO;
import com.zj.videoservice.entity.vo.NewCommentVO;
import com.zj.videoservice.mapper.OutdoorPraiseMapper;
import com.zj.videoservice.mapper.OutdoorVideoCommentMapper;
import com.zj.videoservice.service.OutdoorVideoCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 视频评论表 服务实现类
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@Service
public class OutdoorVideoCommentServiceImpl extends ServiceImpl<OutdoorVideoCommentMapper, OutdoorVideoComment> implements OutdoorVideoCommentService {

    @Autowired
    private  OutdoorVideoCommentMapper commentMapper;

/*
    @Override
    public List<CommentVO> listComments(Long videoId) {
        List<CommentVO> commentList = commentMapper.listComments(videoId);
        if (commentList==null) {
            return commentList;
        }
        for (int i = 0; i < commentList.size(); i++) {
            CommentVO commentVO = commentList.get(i);
            Integer commentPraiseNum = praiseMapper.countCommentPraiseNum(commentVO.getId()).getPraiseNum();
            commentVO.setPraiseNum(commentPraiseNum);
        }
        return commentList;
    }*/


    @Override
    public void insertComment(NewCommentVO newCommentVo) {
        OutdoorVideoComment comment = new OutdoorVideoComment();
        comment.setUid(newCommentVo.getUid());
        comment.setContent(newCommentVo.getContent());
        comment.setGmtCreate(new Date());
        comment.setGmtModified(new Date());
        comment.setVideoId(newCommentVo.getVideoId());
        baseMapper.insert(comment);
    }

    @Override
    public void updateComment(Long id) {
        QueryWrapper<OutdoorVideoComment> commentWrapper = new QueryWrapper<>();
        commentWrapper.eq("id", id);
        OutdoorVideoComment comment = new OutdoorVideoComment();
        comment.setIsDeleted(true);
        comment.setGmtModified(new Date());
        baseMapper.update(comment, commentWrapper);
    }
}
