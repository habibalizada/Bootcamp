package com.trilogyed.commentqueueconsumer.util.feign;

import com.trilogyed.commentqueueconsumer.util.messages.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "comment-service")
public interface CommentClient {

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Comment createComment(@RequestBody Comment comment);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.PUT)
    public String updateComment(@RequestBody Comment comment, @PathVariable int id);
}
