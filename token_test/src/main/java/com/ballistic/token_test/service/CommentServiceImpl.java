package com.ballistic.token_test.service;


import com.ballistic.token_test.domain.model.Comment;
import com.ballistic.token_test.exception.ResourceNotFoundException;
import com.ballistic.token_test.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nabeel on 11/30/2017.
 */
@Service
public class CommentServiceImpl implements ICommentService{

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Comment getCommentById(Integer id) {
        Comment comment = commentRepository.findOne(id);
        if(comment == null){
            throw new ResourceNotFoundException(id, "user not found");
        }
        return comment;
    }

    @Override
    public Comment createComment(Comment user) {
        return commentRepository.save(user);
    }

    @Override
    public Comment updateComment(Comment user) {
        return commentRepository.save(user);
    }

    @Override
    public void deleteComment(Integer id) {

        Comment comment = getCommentById(id);
        commentRepository.delete(comment);

    }
}
