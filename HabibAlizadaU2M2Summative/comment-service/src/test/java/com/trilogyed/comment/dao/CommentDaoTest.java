package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoTest {

    @Autowired
    protected CommentDao commentDao;

    @Before
    public void setUp() throws Exception{
        List<Comment> commentList = commentDao.getAllComments();
        commentList.stream().forEach(comment -> commentDao.deleteComment(comment.getCommentId()));
    }

    @After
    public void tearDown() throws Exception{
        List<Comment> commentList = commentDao.getAllComments();
        commentList.stream().forEach(comment -> commentDao.deleteComment(comment.getCommentId()));
    }

    @Test
    public void addGetDeleteComment(){
        /*
        *  private int commentId;
    private int postId;
    private LocalDate createDate;
    private String commenterName;
    private String comment;
        * */
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,15));
        comment.setCommenterName("John Doe");
        comment.setComment("This comment 1");

        comment = commentDao.createComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());
        assertEquals(comment1, comment);

        commentDao.deleteComment(comment.getCommentId());

        comment1 = commentDao.getComment(comment.getCommentId());

        assertNull(comment1);
    }

    @Test
    public void updateComment(){
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,15));
        comment.setCommenterName("John Doe");
        comment.setComment("This comment 1");

        comment = commentDao.createComment(comment);

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,15));
        comment.setCommenterName("John Doe2");
        comment.setComment("This comment 2");

        commentDao.updateComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());

        assertEquals(comment1, comment);
    }

    @Test
    public void getAllComments(){

        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,15));
        comment.setCommenterName("John Doe");
        comment.setComment("This comment 1");

        comment = commentDao.createComment(comment);

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,15));
        comment.setCommenterName("John Doe2");
        comment.setComment("This comment 2");

        commentDao.createComment(comment);

        List<Comment> commentList = commentDao.getAllComments();
        assertEquals(2, commentList.size());
    }


    @Test
    public void getAllCommentsByPostId(){
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,15));
        comment.setCommenterName("John Doe");
        comment.setComment("This comment 1");

        comment = commentDao.createComment(comment);

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,15));
        comment.setCommenterName("John Doe");
        comment.setComment("This comment 2");

        commentDao.createComment(comment);

        List<Comment> commentList = commentDao.getAllCommentsByPostId(1);
        assertEquals(2, commentList.size());
    }
}
