package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDaoJdbcTemplateImpl;
import com.trilogyed.comment.exception.NotFoundException;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    CommentDaoJdbcTemplateImpl commentDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody @Valid Comment comment){
        return commentDao.createComment(comment);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getCommentById(@PathVariable("id") int id){
        Comment comment = commentDao.getComment(id);
        if (comment == null){
            throw new NotFoundException("No note was found with note_id " + id);
        }
        return comment;
    }

    @GetMapping("/comment/{post_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getCommentForPostId(@PathVariable("post_id") int post_id){
        List<Comment> commentList = commentDao.getAllCommentsByPostId(post_id);
        return commentList;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments(){
        return commentDao.getAllComments();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateComment(@PathVariable("id") int id, @RequestBody @Valid Comment comment){
        if (comment.getCommentId() == 0){
            comment.setCommentId(id);
        }
        if (id != comment.getCommentId()){
            throw new IllegalArgumentException("Comment ID on path must match the ID in the Comment object");
        }

        String updateResponse = commentDao.updateComment(comment);
        String response = updateResponse;

        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteComment(@PathVariable("id") int id){
        return commentDao.deleteComment(id);
    }

}
