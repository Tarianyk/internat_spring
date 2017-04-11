package com.home.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.home.repository")
@EnableTransactionManagement
@PropertySource("classpath:database_config.properties")
public class DataBaseConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(getConfiguration());
    }

    private HikariConfig getConfiguration() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("driver.db"));
        config.setJdbcUrl(env.getProperty("url.db"));
        config.setUsername(env.getProperty("username.db"));
        config.setPassword(env.getProperty("password.db"));
        config.addDataSourceProperty("cachePrepStmts", env.getProperty("cachePrepStmts.db"));
        config.addDataSourceProperty("prepStmtCacheSize", env.getProperty("prepStmtCacheSize.db"));
        config.addDataSourceProperty("prepStmtCacheSqlLimit", env.getProperty("prepStmtCacheSqlLimit.db"));

        return config;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);

        return hibernateJpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("com.home.repository.entity");

        return lef;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory(dataSource, jpaVendorAdapter).getObject());
        return transactionManager;
    }

}