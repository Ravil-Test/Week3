package ru.nurullin.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.nurullin.entity.Supplier;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SupplierDaoImp implements SupplierDao {

    public final JdbcTemplate jdbcTemplate;

    public SupplierDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void save(Supplier supplier) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO suppliers (orgname, address) VALUES(?, ?)");

            preparedStatement.setString(1, supplier.getOrgname());
            preparedStatement.setString(2, supplier.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Supplier getById(int id) {
        Supplier supplier = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM suppliers WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            supplier = new Supplier();

            supplier.setId(resultSet.getInt("id"));
            supplier.setOrgname(resultSet.getString("orgname"));
            supplier.setAddress(resultSet.getString("address"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return supplier;
    }

    @Override
    public List<Supplier> findAll() {
        List<Supplier> suppliers = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM suppliers";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Supplier supplier = new Supplier();

                supplier.setId(resultSet.getInt("id"));
                supplier.setOrgname(resultSet.getString("orgname"));
                supplier.setAddress(resultSet.getString("address"));

                suppliers.add(supplier);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return suppliers;
    }

    @Override
    public void update(Supplier supplier) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE suppliers SET orgname=?, address=? WHERE id=?");

            preparedStatement.setString(1, supplier.getOrgname());
            preparedStatement.setString(2, supplier.getAddress());
            preparedStatement.setInt(3, supplier.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM suppliers WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
