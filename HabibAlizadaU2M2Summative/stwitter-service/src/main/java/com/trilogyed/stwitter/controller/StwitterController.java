package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.feignClient.PostClient;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostViewModel;
import com.trilogyed.stwitter.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@CacheConfig(cacheNames = {"stwitter"})
public class StwitterController {


    @Autowired
    ServiceLayer service;


    @CachePut(key = "#result.getId()")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel createPost(@RequestBody @Valid PostViewModel postViewModel) {
        System.out.println("CREATING POST");
        return service.createPostWithComments(postViewModel);
    }

    @Cacheable
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPost(@PathVariable int id) {
        System.out.println("GETTING POST ID = " + id);
        return service.fidnPost(id);
    }

    @Cacheable
    @RequestMapping(value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getPostByPoster(@PathVariable("poster_name") String posterName){
        return service.getPostByPoster(posterName);
    }

//    @RequestMapping(value = "/posts/", method = RequestMethod.GET)
//    public List<Post> getAllPosts(){
//        return client.getAllPosts();
//    }
//
//    @CacheEvict(key = "#rsvp.getId()")
//    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
//    public void updatePost(@RequestBody PostViewModel postViewModel, @PathVariable int id){
//        service.updatePost( postViewModel, id);
//    }
////
//    @CacheEvict
//    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
//    public void deletePost(@PathVariable int id){
//        service.removePost(id);
//    }


}
