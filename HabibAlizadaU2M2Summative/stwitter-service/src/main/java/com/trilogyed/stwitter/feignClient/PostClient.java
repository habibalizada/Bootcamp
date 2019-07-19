package com.trilogyed.stwitter.feignClient;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import javafx.geometry.Pos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "post-service")
public interface PostClient {

    @RequestMapping(value = "/posts" , method = RequestMethod.POST)
    public Post createPost(@RequestBody @Valid Post post);

    @RequestMapping(value = "/posts/user/{poster_name}" , method = RequestMethod.GET)
    public List<Post> getPostByPoster(@PathVariable("poster_name") String posterName);

    @RequestMapping(value = "/posts/{id}" , method = RequestMethod.GET)
    public Post getPost(@PathVariable("id") int id);

    @RequestMapping(value = "/posts/", method = RequestMethod.GET)
    public List<Post> getAllPosts();

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) ;

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id);

}
