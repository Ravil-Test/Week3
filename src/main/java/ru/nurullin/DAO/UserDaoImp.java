package ru.nurullin.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.nurullin.mapper.UserMapper;
import ru.nurullin.entity.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    public UserDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (id, name, email, age) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getEmail(), user.getAge());

    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject( sql, new UserMapper(), id);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
