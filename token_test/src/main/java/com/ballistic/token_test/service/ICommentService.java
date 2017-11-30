package com.ballistic.token_test.service;


import com.ballistic.token_test.domain.model.Comment;

/**
 * Created by Nabeel on 11/30/2017.
 */

public interface ICommentService {

    Comment getCommentById(Integer id);

    Comment createComment(Comment user);

    Comment updateComment(Comment user);

    void deleteComment(Integer id);

}
