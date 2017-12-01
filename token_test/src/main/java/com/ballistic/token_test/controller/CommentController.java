package com.ballistic.token_test.controller;

import com.ballistic.token_test.assemblers.ICommentAssembler;

import com.ballistic.token_test.domain.model.Comment;
import com.ballistic.token_test.service.ICommentService;
import com.ballistic.token_test.vo.CommentVO;
import com.ballistic.token_test.vo.CreateCommentVO;
import com.ballistic.token_test.vo.UpdateCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    public String method7(@PathVariable("id") int id) {
        return "method7 with id=" + id;
    }


    public String method8(@PathVariable("id") long id, @PathVariable("name") String name){
        return "method8 with id= "+id+" and name="+name;
    }

    @RequestMapping(value="/method9")
    public String method9(@RequestParam("id") int id){
        return "method9 with id= "+id;
    }
}
