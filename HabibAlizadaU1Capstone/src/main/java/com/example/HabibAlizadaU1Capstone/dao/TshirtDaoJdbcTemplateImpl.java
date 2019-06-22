package com.example.HabibAlizadaU1Capstone.dao;

import com.example.HabibAlizadaU1Capstone.model.Tshirt;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TshirtDaoJdbcTemplateImpl implements TshirtDao {

    private static final String INSERT_TSHIRT_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";
    private static final String SELECT_TSHIRT_SQL =
            "select * from t_shirt where t_shirt_id = ?";
    private static final String SELECT_ALL_TSHIRTS_SQL =
            "select * from t_shirt";
    private static final String UPDATE_TSHIRT_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";
    private static final String DELETE_TSHIRT_SQL =
            "delete from t_shirt where t_shirt_id = ?";
    private static final String SELECT_TSHIRT_BY_COLOR =
            "select * from t_shirt where color = ?";
    private static final String SELECT_TSHIRT_BY_SIZE =
            "select * from t_shirt where size = ?";


    private JdbcTemplate jdbcTemplate;

    public TshirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tshirt addTshirt(Tshirt tshirt) {
        jdbcTemplate.update(
                INSERT_TSHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity()
        );

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        tshirt.settShirtId(id);

        return tshirt;
    }

    @Override
    public Tshirt getTshirt(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TSHIRT_SQL, this::mapRowToTshirt, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Tshirt> getAllTshirt() {
        return jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL, this::mapRowToTshirt);
    }

    /*
    * t_shirt_id int(11) not null auto_increment primary key,
    size varchar(20) not null,
    color varchar(20) not null,
    description varchar(255) not null,
    price decimal(5,2) not null,
    quantity int(11) not null

    * */

    @Override
    public void updateTshirt(Tshirt tshirt) {
        jdbcTemplate.update(
                UPDATE_TSHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity(),
                tshirt.gettShirtId()
        );

    }

    @Override
    public void deleteTshirt(int id) {
        jdbcTemplate.update(DELETE_TSHIRT_SQL, id);

    }

    @Override
    public List<Tshirt> getTshirtByColor(String color) {
        return jdbcTemplate.query(SELECT_TSHIRT_BY_COLOR, this::mapRowToTshirt, color);
    }

    @Override
    public List<Tshirt> getTshirtBySize(String size) {
        return jdbcTemplate.query(SELECT_TSHIRT_BY_SIZE, this::mapRowToTshirt, size);
    }

    private Tshirt mapRowToTshirt(ResultSet rs, int rowNum) throws SQLException {
        Tshirt tshirt = new Tshirt();
        tshirt.settShirtId(rs.getInt("t_shirt_id"));
        tshirt.setSize(rs.getString("size"));
        tshirt.setColor(rs.getString("color"));
        tshirt.setDescription(rs.getString("description"));
        tshirt.setPrice(rs.getDouble("price"));
        tshirt.setQuantity(rs.getInt("quantity"));
        return tshirt;
    }
}
