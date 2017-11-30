package com.ballistic.token_test.controller;

import com.ballistic.token_test.assemblers.ICommentAssembler;

import com.ballistic.token_test.domain.model.Comment;
import com.ballistic.token_test.service.ICommentService;
import com.ballistic.token_test.vo.CommentVO;
import com.ballistic.token_test.vo.CreateCommentVO;
import com.ballistic.token_test.vo.UpdateCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Nabeel on 11/30/2017.
 */
@RestController
public class CommentController implements ICommentController{

    @Autowired
    private ICommentAssembler icommentAssembler;

    @Autowired
    private ICommentService iCommentService;

    @Override
    public CommentVO getComment(@PathVariable("id") Integer id) {
        return icommentAssembler.toCommentVO(iCommentService.getCommentById(id));
    }

    @Override
    public CommentVO createComment(@Valid @RequestBody CreateCommentVO createCommentVO) {
        // convert to comment
        Comment comment = icommentAssembler.toComment(createCommentVO);
        // save comment
        Comment saveComment = iCommentService.createComment(comment);

        return icommentAssembler.toCommentVO(saveComment);
    }

    @Override
    public CommentVO updateComment(@Valid @RequestBody UpdateCommentVO updateCommentVO) {
        // convert to comment
        Comment comment = icommentAssembler.toComment(updateCommentVO);
        // update comment
        Comment updateComment = iCommentService.updateComment(comment);
        //convert to UserVO
        return icommentAssembler.toCommentVO(updateComment);

    }

    @Override
    public void delete(@PathVariable("id") Integer id) {
        iCommentService.deleteComment(id);
    }
}
