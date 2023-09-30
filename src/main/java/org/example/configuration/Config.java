package org.example.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories("org.example")
@EnableTransactionManagement
@PropertySource(value = "classpath:datasource.properties")
public class Config {

    private final Environment environment;

    @Autowired
    public Config(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource () {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setJdbcUrl(environment.getRequiredProperty("hikari.jdbcUrl"));
            hikariConfig.setUsername(environment.getRequiredProperty("hikari.user"));
            hikariConfig.setPassword(environment.getRequiredProperty("hikari.password"));
            return new HikariDataSource(hikariConfig);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("org.example");
        factory.setDataSource(dataSource());
        factory.setJpaPropertyMap(hibernateProperties());
        return factory;
    }

    @Bean
    Map<String, Object> hibernateProperties() {
        Map<String, Object> propertyMap = new HashMap<>();
        propertyMap.put("hibernate.format_sql", true);
        return propertyMap;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    @Bean
    public SessionFactory sessionFactory(){
        return entityManagerFactory().getNativeEntityManagerFactory().unwrap(SessionFactory.class);
    }
}
