package com.ballistic.token_test.repository;


import com.ballistic.token_test.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Nabeel on 11/30/2017.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

    String COUNT_TOTAL_COMMENT = "SELECT count(comment.id) FROM Comment comment";

//    @Modifying
    @Transactional
    @Query(COUNT_TOTAL_COMMENT)
    public Integer getTotalComment();
}
