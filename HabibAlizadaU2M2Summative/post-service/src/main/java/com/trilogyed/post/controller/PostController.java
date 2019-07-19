package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDaoJdbcTemplateImpl;
import com.trilogyed.post.exception.NotFoundException;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class PostController {

    @Autowired
    PostDaoJdbcTemplateImpl postDao;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Post createPost(@RequestBody @Valid Post post) {
        return postDao.createPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable("id") int id) {
        Post post = postDao.getPost(id);
//        if (post == null){
//            throw new NotFoundException("No post was found with post_id " + id);
//        }
        return post;
    }

    @RequestMapping(value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getPostByPoster(@PathVariable("poster_name") String poster_name){
        List<Post> postList = postDao.getPostByPoster(poster_name);
        return postList;
    }

    @RequestMapping(value = "/posts/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts(){
        return postDao.getAllPosts();
    }


    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {
        if (post.getPostID() == 0){
            post.setPostID(id);
        }
        if (id != post.getPostID()){
            throw new IllegalArgumentException("Post ID on path must match the ID in the Post object");
        }
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable int id) {
        postDao.deletePost(id);
    }
}
