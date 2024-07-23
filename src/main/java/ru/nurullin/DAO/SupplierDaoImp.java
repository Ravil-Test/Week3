package ru.nurullin.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.nurullin.entity.Supplier;
import ru.nurullin.mapper.SupplierMapper;

import java.util.List;

@Repository
public class SupplierDaoImp implements SupplierDao {

    public final JdbcTemplate jdbcTemplate;

    public SupplierDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Supplier supplier) {
        String sql = "INSERT INTO suppliers (orgname, address) VALUES (?,?)";
        jdbcTemplate.update(sql, supplier.getOrgname(), supplier.getAddress());

    }

    @Override
    public Supplier getById(int id) {
        String sql = "SELECT * FROM suppliers WHERE id = ?";
        return jdbcTemplate.queryForObject( sql, new SupplierMapper(), id);
    }

    @Override
    public List<Supplier> findAll() {
        String sql = "SELECT * FROM suppliers";
        return jdbcTemplate.query(sql, new SupplierMapper());
    }

    @Override
    public void update(Supplier supplier) {
        String sql = "UPDATE suppliers SET orgname = ?, address = ? WHERE id = ?";
        jdbcTemplate.update(sql, supplier.getOrgname(), supplier.getAddress(), supplier.getId());

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM suppliers WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
