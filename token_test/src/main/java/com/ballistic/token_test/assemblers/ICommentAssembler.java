package com.ballistic.token_test.assemblers;

import com.ballistic.token_test.domain.model.Comment;
import com.ballistic.token_test.vo.CommentVO;
import com.ballistic.token_test.vo.CreateCommentVO;
import com.ballistic.token_test.vo.UpdateCommentVO;

/**
 * Created by Nabeel on 11/30/2017.
 */
public interface ICommentAssembler {

    public Comment toComment(CreateCommentVO createCommentVO);
    public CommentVO toCommentVO(Comment comment);
    public Comment toComment(UpdateCommentVO updateCommentVO);


}
