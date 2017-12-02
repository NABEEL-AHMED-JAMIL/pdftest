package com.ballistic.token_test.controller;

import com.ballistic.token_test.vo.CommentVO;
import com.ballistic.token_test.vo.CreateCommentVO;
import com.ballistic.token_test.vo.UpdateCommentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Nabeel on 11/30/2017.
 */
@RequestMapping(value = "/api/v1")
@Api(value="customer", description="Customer Operation handling")
public interface ICommentController {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The Data not contain")
    })
    @ApiOperation(value = "Search with an Id", response = CommentVO.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommentVO getComment(@PathVariable("id") Integer id);

    @ApiOperation(value = "New Comment Save", response = CommentVO.class)
    @RequestMapping(method = RequestMethod.POST)
    public CommentVO createComment(@Valid @RequestBody CreateCommentVO createCommentVO);

    @ApiOperation(value = "Update Comment", response = CommentVO.class)
    @RequestMapping(method = RequestMethod.PUT)
    public CommentVO updateComment(@Valid @RequestBody UpdateCommentVO updateCommentVO);

    @ApiOperation(value = "Delete Comment by Id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id);

    @ApiOperation(value = "Send ID In Method 7")
    @RequestMapping(value="/method7/{id}", method = RequestMethod.GET)
    public String method7(@PathVariable("id") int id);

    @ApiOperation(value = "Send ID and Name In Method 8")
    @RequestMapping(value="/method8/{id:[\\d]+}/{name}", method = RequestMethod.GET)
    public String method8(@PathVariable("id") long id, @PathVariable("name") String name);

    @ApiOperation(value = "Send ID In Method 9")
    @RequestMapping(value="/method9", method = RequestMethod.GET)
    public String method9(@RequestParam(name = "id", required = false, defaultValue = "1") int id);

}
