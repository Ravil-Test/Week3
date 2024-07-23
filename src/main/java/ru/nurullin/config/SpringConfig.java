package ru.nurullin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.nurullin.DAO.SupplierDao;
import ru.nurullin.DAO.SupplierDaoImp;
import ru.nurullin.service.SupplierService;
import ru.nurullin.service.SupplierServiceImp;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@ComponentScan(basePackages = {"ru.nurullin.DAO", "ru.nurullin.service"})
@PropertySource("classpath:database.properties")
public class SpringConfig {

    private final Environment environment;

    public SpringConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("username"));
        dataSource.setPassword(environment.getProperty("password"));
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("driver")));
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
