package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoTest {

    @Autowired
    protected PostDao postDao;

    @Before
    public void setUp() throws Exception{
        List<Post> postList = postDao.getAllPosts();
        postList.stream().forEach(post -> postDao.deletePost(post.getPostID()));
    }

    @After
    public void tearDown() throws Exception{
        List<Post> postList = postDao.getAllPosts();
        postList.stream().forEach(post -> postDao.deletePost(post.getPostID()));
    }

    @Test
    public void addGetDeletePost(){
        Post post = new Post();

        post.setPostDate(LocalDate.of(2019,7,15));
        post.setPosterName("John Doe");
        post.setPost("This is a post number 1");

        post = postDao.createPost(post);

        Post post1 = postDao.getPost(post.getPostID());
        assertEquals(post1, post);

        postDao.deletePost(post.getPostID());

        post1 = postDao.getPost(post.getPostID());

        assertNull(post1);
    }

    @Test
    public void updatePost(){
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019,7,15));
        post.setPosterName("John Doe");
        post.setPost("This is a post number 1");

        post = postDao.createPost(post);

        post.setPostDate(LocalDate.of(2019,7,15));
        post.setPosterName("John Doe2");
        post.setPost("This is a post number 2");

        postDao.updatePost(post);

        Post post1 = postDao.getPost(post.getPostID());

        assertEquals(post1, post);

    }

    @Test
    public void getAllPosts(){
        Post post = new Post();

        post.setPostDate(LocalDate.of(2019,7,15));
        post.setPosterName("John Doe");
        post.setPost("This is a post number 1");

        post = postDao.createPost(post);

        Post post1 = new Post();

        post1.setPostDate(LocalDate.of(2019,7,15));
        post1.setPosterName("John Doe2");
        post1.setPost("This is a post number 2");

        postDao.createPost(post1);

        List<Post> postList = postDao.getAllPosts();
        assertEquals(2, postList.size());
    }

    @Test
    public void getPostByPoster(){
        Post post = new Post();

        post.setPostDate(LocalDate.of(2019,7,15));
        post.setPosterName("John Doe");
        post.setPost("This is a post number 1");

        post = postDao.createPost(post);

        Post post1 = new Post();

        post1.setPostDate(LocalDate.of(2019,7,15));
        post1.setPosterName("John Doe");
        post1.setPost("This is a post number 2");

        postDao.createPost(post1);

        List<Post> postList = postDao.getPostByPoster("John Doe");
        assertEquals(2, postList.size());

    }


}
