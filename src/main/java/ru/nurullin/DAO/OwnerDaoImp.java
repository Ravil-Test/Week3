package ru.nurullin.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.nurullin.entity.Owner;
import ru.nurullin.mapper.UserMapper;

import java.util.List;

@Repository
public class OwnerDaoImp implements OwnerDao {

    public final JdbcTemplate jdbcTemplate;

    public OwnerDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Owner owner) {
        String sql = "INSERT INTO owners (id, name, surname, email, telnumber) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, owner.getId(), owner.getName(), owner.getSurname(), owner.getEmail(), owner.getTelnumber());

    }

    @Override
    public Owner getById(int id) {
        String sql = "SELECT * FROM owners WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public List<Owner> findAll() {
        String sql = "SELECT * FROM owners";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void update(Owner owner) {
        String sql = "UPDATE owners SET name = ?, surname = ?, email = ?, telnumber = ? WHERE id = ?";
        jdbcTemplate.update(sql, owner.getName(), owner.getSurname(), owner.getEmail(), owner.getTelnumber(), owner.getId());

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM owners WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
