package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentDaoJdbcTemplateImpl implements CommentDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String INSERT_COMMENT =
            "insert into comment (post_id, create_date, commenter_name, comment) values (?, ?, ?, ?)";

    private static final String SELECT_COMMENT =
            "select * from comment where comment_id = ?";

    private static final String SELECT_ALL_COMMENTS =
            "select * from comment";

    private static final String SELECT_ALL_COMMENTS_BY_POST_ID =
            "select * from comment where post_id = ?";

    private static final String UPDATE_COMMENT =
            "update comment set post_id = ? , create_date = ?, commenter_name = ? , comment = ? where comment_id = ?";

    private static final String DELETE_BOOK =
            "delete from comment where comment_id = ?";

    @Override
    @Transactional
    public Comment createComment(Comment comment) {
       jdbcTemplate.update(INSERT_COMMENT,
               comment.getPostId(),
               comment.getCreateDate(),
               comment.getCommenterName(),
               comment.getComment());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        comment.setCommentId(id);

        return comment;
    }

    @Override
    public Comment getComment(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COMMENT, this::mapRowToComment, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Comment> getAllComments() {
        return jdbcTemplate.query(SELECT_ALL_COMMENTS, this::mapRowToComment);
    }

    @Override
    public List<Comment> getAllCommentsByPostId(int id) {
        return jdbcTemplate.query(SELECT_ALL_COMMENTS_BY_POST_ID, this::mapRowToComment, id);
    }

    @Override
    public String updateComment(Comment comment) {
        int numRowUpdated = jdbcTemplate.update(UPDATE_COMMENT,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment(),
                comment.getCommentId());
        int id = comment.getCommentId();
        String updateSuccessfulMsg = "Comment with comment_id " + id + " has been updated.";
        String updateFailedMsg = "No comments updated. No comment with comment_id " + id + " was found.";

        return numRowUpdated == 1 ? updateSuccessfulMsg : updateFailedMsg;
    }

    @Override
    public String deleteComment(int id) {
        int numRowDeleted = jdbcTemplate.update(DELETE_BOOK, id);
        String deleteSuccessfulMsg = "Comment with comment_id " + id + " has been deleted.";
        String deleteFailedMsg = "No comments deleted. No comment with comment_id " + id + " was found.";

        return numRowDeleted == 1 ? deleteSuccessfulMsg : deleteFailedMsg;
    }

    public Comment mapRowToComment(ResultSet rs, int rowNum)throws SQLException{
        Comment comment = new Comment();
        comment.setPostId(rs.getInt("post_id"));
        comment.setCreateDate(rs.getDate("create_date").toLocalDate());
        comment.setCommenterName(rs.getString("commenter_name"));
        comment.setComment(rs.getString("comment"));
        comment.setCommentId(rs.getInt("comment_id"));

        return comment;
    }
}
