package ru.nurullin.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.nurullin.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierMapper implements RowMapper<Supplier> {
    @Override
    public Supplier mapRow(ResultSet resultSet, int i) throws SQLException {
        Supplier supplier = new Supplier();
        supplier.setId(resultSet.getInt("id"));
        supplier.setOrgname(resultSet.getString("orgname"));
        supplier.setAddress(resultSet.getString("address"));
        return supplier;
    }
}
