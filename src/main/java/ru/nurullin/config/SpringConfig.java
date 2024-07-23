package ru.nurullin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.nurullin.DAO.SupplierDao;
import ru.nurullin.DAO.SupplierDaoImp;
import ru.nurullin.service.SupplierService;
import ru.nurullin.service.SupplierServiceImp;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"ru.nurullin.DAO", "ru.nurullin.service"})
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/first_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    public SupplierDao getUserDao() {
        return new SupplierDaoImp(getJdbcTemplate());
    }

    @Bean
    public SupplierService getUserService() {
        return new SupplierServiceImp();
    }
}
