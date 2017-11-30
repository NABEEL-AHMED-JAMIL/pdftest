package com.ballistic.token_test.assemblers;


import com.ballistic.token_test.domain.model.Comment;
import com.ballistic.token_test.vo.CommentVO;
import com.ballistic.token_test.vo.CreateCommentVO;
import com.ballistic.token_test.vo.UpdateCommentVO;
import org.springframework.stereotype.Component;

/**
 * Created by Nabeel on 11/30/2017.
 */
@Component
public class CommentAssembler implements ICommentAssembler{

    public Comment toComment(CreateCommentVO createCommentVO) {
        Comment comment = new Comment();
        comment.setFrom(createCommentVO.getFrom());
        comment.setTo(createCommentVO.getTo());
        comment.setTitle(createCommentVO.getTitle());
        comment.setBody(createCommentVO.getBody());
        comment.setCreated(createCommentVO.getCreated());
        return comment;
    }

    public CommentVO toCommentVO(Comment comment){
        CommentVO commentVO = new CommentVO();
        commentVO.setId(comment.getId());
        commentVO.setFrom(comment.getFrom());
        commentVO.setTo(comment.getTo());
        commentVO.setTitle(comment.getTitle());
        commentVO.setBody(comment.getBody());
        commentVO.setCreated(comment.getCreated());
        commentVO.setUpdated(comment.getUpdated());
        return commentVO;
    }

    public Comment toComment(UpdateCommentVO updateCommentVO) {

        Comment comment =  new Comment();
        comment.setId(updateCommentVO.getId());
        comment.setTo(updateCommentVO.getTo());
        comment.setFrom(updateCommentVO.getFrom());
        comment.setTitle(updateCommentVO.getTitle());
        comment.setBody(updateCommentVO.getBody());
        comment.setUpdated(updateCommentVO.getUpdated());
        return comment;

    }

}
