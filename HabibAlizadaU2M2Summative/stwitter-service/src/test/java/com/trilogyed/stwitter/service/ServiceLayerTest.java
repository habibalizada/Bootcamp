package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.feignClient.CommentClient;
import com.trilogyed.stwitter.feignClient.PostClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    @Mock
    RabbitTemplate rabbitTemplate;
    @Mock
    PostClient postClient;
    @Mock
    CommentClient commentClient;
    /*
    *
    private int postID;
    @NotNull(message = "Post date cannot be null")
    private LocalDate postDate;
    @NotNull(message = "Poster name cannot be null")
    private String posterName;
    private String post;
    * */

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        setUpComment();
        setUpPost();
        serviceLayer = new ServiceLayer(rabbitTemplate, commentClient, postClient);

    }
    public void setUpComment(){
        commentClient = mock(CommentClient.class);
        List<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,17));
        comment.setCommenterName("john doe");
        comment.setComment("This is comment 1");
        commentList.add(comment);

        Comment comment1 = new Comment();
        comment1.setPostId(1);
        comment1.setCreateDate(LocalDate.of(2019,7,17));
        comment1.setCommenterName("john doe");
        comment1.setComment("This is comment 2");

        commentList.add(comment1);

        doReturn(commentList).when(commentClient).getCommentsByPostId(1);
    }

    public void setUpPost(){
        postClient = mock(PostClient.class);

        Post post = new Post();
        post.setPostID(1);
        post.setPostDate(LocalDate.of(2019,7,17));
        post.setPosterName("David");
        post.setPost("This is post 1");

        Post post1 = new Post();
        post1.setPostDate(LocalDate.of(2019,7,17));
        post1.setPosterName("David");
        post1.setPost("This is post 1");

        List<Post> postList = new ArrayList<>();
        postList.add(post);

        doReturn(post).when(postClient).createPost(post1);
        doReturn(post).when(postClient).getPost(1);
        doReturn(postList).when(postClient).getPostByPoster("David");
    }

    @Test
    public void createPost(){
        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setPostDate(LocalDate.of(2019,7,17));
        postViewModel.setPosterName("David");
        postViewModel.setPost("This is post 1");
        postViewModel.setCommentList(commentClient.getCommentsByPostId(1));

        postViewModel = serviceLayer.createPostWithComments(postViewModel);

        PostViewModel postViewModel1 = serviceLayer.fidnPost(postViewModel.getId());
        assertEquals(postViewModel, postViewModel1);
    }

    @Test
    public void getPostById(){
        PostViewModel postViewModel = serviceLayer.fidnPost(1);
        postViewModel.setPostDate(LocalDate.of(2019,7,17));
        postViewModel.setPosterName("David");
        postViewModel.setPost("This is post 1");
        postViewModel.setCommentList(commentClient.getCommentsByPostId(1));

        postViewModel = serviceLayer.createPostWithComments(postViewModel);

        PostViewModel postViewModel1 = serviceLayer.fidnPost(postViewModel.getId());
        assertEquals(postViewModel, postViewModel1);

    }

    @Test
    public void getPostByPosterName(){
        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setId(1);
        postViewModel.setPostDate(LocalDate.of(2019,7,17));
        postViewModel.setPosterName("David");
        postViewModel.setPost("This is post 1");
        postViewModel.setCommentList(commentClient.getCommentsByPostId(1));

        postViewModel = serviceLayer.createPostWithComments(postViewModel);

        List<PostViewModel> postViewModelList = serviceLayer.getPostByPoster(postViewModel.getPosterName());

        assertEquals(1, postViewModelList.size());
        assertEquals(postViewModel, postViewModelList.get(0));


    }

//    @Test
//    public void saveFindFindByPoster(){
//        List<Comment> commentList = new ArrayList<>();
//        Comment comment = new Comment();
//        comment.setCommentId(1);
//        comment.setPostId(1);
//        comment.setCreateDate(LocalDate.of(2019,7,17));
//        comment.setCommenterName("john doe");
//        comment.setComment("This is comment 1");
//        commentList.add(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setCommentId(2);
//        comment1.setPostId(1);
//        comment1.setCreateDate(LocalDate.of(2019,7,17));
//        comment1.setCommenterName("john doe");
//        comment1.setComment("This is comment 2");
//        commentList.add(comment1);
//
//
//        PostViewModel postViewModel = new PostViewModel();
//        //postViewModel.setId(1);
//
//
//        postViewModel = serviceLayer.createPostWithComments(postViewModel);
//
//        PostViewModel fromService = serviceLayer.fidnPost(postViewModel.getId());
//        assertEquals(fromService, postViewModel);
//
//        List<PostViewModel> postViewModelList = new ArrayList<>();
//        postViewModelList.add(postViewModel);
//
//        List<PostViewModel> fromServiceList = serviceLayer.findAllPosts();
//        assertEquals(fromServiceList, postViewModelList.size());
//
//    }
}
