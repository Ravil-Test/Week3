package ru.nurullin.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.nurullin.entity.Owner;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<Owner> {
    @Override
    public Owner mapRow(ResultSet resultSet, int i) throws SQLException {
        Owner owner = new Owner();
        owner.setId(resultSet.getInt("id"));
        owner.setName(resultSet.getString("name"));
        owner.setSurname(resultSet.getString("surname"));
        owner.setEmail(resultSet.getString("email"));
        owner.setTelnumber(resultSet.getInt("telnumber"));
        return owner;
    }
}
