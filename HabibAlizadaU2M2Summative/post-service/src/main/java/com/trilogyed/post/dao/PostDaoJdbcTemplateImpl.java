package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoJdbcTemplateImpl implements PostDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PostDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_POST =
            "insert into post (post_date, poster_name, post) values (?, ?, ?)";

    private static final String SELECT_POST =
            "select * from post where post_id = ?";

    private static final String SELECT_ALL_POSTS =
            "select * from post";

    private static final String SELECT_ALL_POSTS_BY_POSTER_NAME =
            "select * from post where poster_name = ?";

    private static final String UPDATE_POST =
            "update post set post_date = ?, poster_name = ?, post = ? where post_id = ?";

    private static final String DELETE_BOOK =
            "delete from post where post_id = ?";

    @Override
    @Transactional
    public Post createPost(Post post) {
        jdbcTemplate.update(INSERT_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        post.setPostID(id);

        return post;
    }

    @Override
    public Post getPost(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_POST, this::mapRowToPost, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Post> getPostByPoster(String posterName) {
        List<Post> postList = jdbcTemplate.query(SELECT_ALL_POSTS_BY_POSTER_NAME, this::mapRowToPost, posterName);
        return postList;
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> postList = jdbcTemplate.query(SELECT_ALL_POSTS, this::mapRowToPost);
        return postList;
    }

    @Override
    @Transactional
    public void updatePost(Post post) {
        jdbcTemplate.update(UPDATE_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                post.getPostID());
    }

    @Override
    public void deletePost(int id) {
        jdbcTemplate.update(DELETE_BOOK, id);
    }

    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostID(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));

        return post;
    }
}
