package com.zj.videoservice.controller;


import com.zj.baseservice.common.R;
import com.zj.videoservice.entity.vo.CommentFlagVO;
import com.zj.videoservice.entity.vo.CommentVO;
import com.zj.videoservice.entity.vo.NewCommentVO;
import com.zj.videoservice.mapper.OutdoorVideoCommentMapper;
import com.zj.videoservice.service.OutdoorVideoCommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 视频评论表 前端控制器
 * </p>
 *
 * @author zj
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/videoservice/comment")
@CrossOrigin
public class OutdoorVideoCommentController {

    @Autowired
    private OutdoorVideoCommentService commentService;


    @Autowired
    private OutdoorVideoCommentMapper commentMapper;

    @PostMapping("/listCommentsOrderByTime")
    @ApiOperation("某视频一级评论按照发布时间降序")
    public R listCommentsOrderByTime(@RequestBody CommentFlagVO commentFlagVO) {
        List<CommentVO> commentList = commentMapper.listCommentsOrderByTime(commentFlagVO);
        return R.ok().data("commentList", commentList);
    }

    @PostMapping("/listCommentsOrderByPraise")
    @ApiOperation("某视频一级评论按照发布时间降序")
    public R listCommentsOrderByPraise(@RequestBody CommentFlagVO commentFlagVO) {
        List<CommentVO> commentList = commentMapper.listCommentsOrderByPraise(commentFlagVO);
        return R.ok().data("commentList", commentList);
    }



    @PostMapping("/addComment")
    @ApiOperation("添加新评论")
    public R addComment(@RequestBody NewCommentVO newCommentVo) {
        commentService.insertComment(newCommentVo);
        return R.ok();
    }

    @GetMapping("/updateComment/{id}")
    @ApiOperation("逻辑删除用户自己发表的评论")
    public R updateComment(@PathVariable Long id) {
        commentService.updateComment(id);
        return R.ok();
    }
}

