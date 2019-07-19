package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.feignClient.CommentClient;
import com.trilogyed.stwitter.feignClient.PostClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {


    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "create.controller";

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private CommentClient commentClient;
    @Autowired
    private PostClient postClient;

    public ServiceLayer(RabbitTemplate rabbitTemplate, CommentClient commentClient, PostClient postClient) {
        this.rabbitTemplate = rabbitTemplate;
        this.commentClient = commentClient;
        this.postClient = postClient;
    }

    @Transactional
    public PostViewModel createPostWithComments(PostViewModel postViewModel){
        Post post = new Post();
        post.setPost(postViewModel.getPost());
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());
        post = postClient.createPost(post);
        postViewModel.setId(post.getPostID());
        List<Comment> commentList = postViewModel.getCommentList();

        for (Comment comment : commentList){
            comment.setPostId(postViewModel.getId());
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment);
        }

        commentList = commentClient.getCommentsByPostId(postViewModel.getId());
        postViewModel.setCommentList(commentList);
        return postViewModel;
    }

    public PostViewModel fidnPost(int id){
        Post post = postClient.getPost(id);
        PostViewModel postViewModel;
        if (post == null){
            throw new NotFoundException("Post id " + id + " not fouend");
        }else {
            postViewModel = buildViewModelFromPost(post);
        }
        return postViewModel;
    }

    public List<PostViewModel> findAllPosts(){
        List<Post> postList = postClient.getAllPosts();
        List<PostViewModel> postViewModelList = new ArrayList<>();

        for (Post post : postList){
            PostViewModel postViewModel = buildViewModelFromPost(post);
            postViewModelList.add(postViewModel);
        }
        return postViewModelList;
    }

    public List<PostViewModel> getPostByPoster(String posterName){
        List<Post> postList = postClient.getPostByPoster( posterName);
        List<PostViewModel> postViewModelList = new ArrayList<>();

        for (Post post : postList){
            PostViewModel postViewModel = buildViewModelFromPost(post);
            postViewModelList.add(postViewModel);
        }
        return postViewModelList;
    }

    @Transactional
    public boolean updatePost(PostViewModel postViewModel, int id){
        Post post = buildPostFromViewModel(postViewModel);
        Post exixtingPost = postClient.getPost(postViewModel.getId());

        boolean isUpdated = false;

        if (exixtingPost == null){
            isUpdated = false;
            throw new NotFoundException("Post id " + postViewModel.getId() + " not found");
        }else {
            postClient.updatePost(post, postViewModel.getId());
            sendCommentsToQueue(postViewModel);
            isUpdated = true;
        }
        return isUpdated;
    }

//    public boolean removePost(int id){
//        boolean isDeleted;
//        Post existingPost = postClient.getPost(id);
//        if (existingPost == null){
//            throw new NotFoundException("Post id " + id + " not found");
//        }else {
//            try {
//                postClient.deletePost(id);
//                isDeleted = true;
//            } catch (Exception e){
//                isDeleted = false;
//            }
//        }
//        return isDeleted;
//    }

    private PostViewModel buildViewModelFromPost(Post post){
        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setId(post.getPostID());
        postViewModel.setPostDate(post.getPostDate());
        postViewModel.setPosterName(post.getPosterName());
        postViewModel.setPost(post.getPost());
        if (commentClient.getCommentsByPostId(post.getPostID()) != null){
            postViewModel.setCommentList(commentClient.getCommentsByPostId(post.getPostID()));
        }else {
            postViewModel.setCommentList(null);
        }
        return postViewModel;
    }

    private Post buildPostFromViewModel(PostViewModel postViewModel){
        Post post = new Post();
        post.setPostID(postViewModel.getId());
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());
        post.setPost(postViewModel.getPost());
        return post;
    }

    private void sendCommentsToQueue(PostViewModel postViewModel){
        List<Comment> commentList = postViewModel.getCommentList();
        List<Comment> existingComments = commentClient.getCommentsByPostId(postViewModel.getId());
        if (postViewModel.getCommentList() != null){
            System.out.println("Sendign comment list");
            for (Comment comment : commentList){
                if (existingComments.stream().anyMatch(existingComment -> existingComment.getCommentId() == comment.getCommentId() || comment.getCommentId() == 0)){
                    comment.setPostId(postViewModel.getId());
                    rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment);
                }else {
                    throw new NotFoundException("Comment id " + comment.getCommentId() + " not found");
                }
            }
            System.out.println("Comment list sent");
        }
    }

}
