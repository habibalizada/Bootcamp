package com.trilogyed.stwitter.feignClient;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentClient {
    @RequestMapping(value = "comment/post/{post_id}" , method = RequestMethod.GET)
    public List<Comment> getCommentsByPostId(@PathVariable("post_id") int id);
}
