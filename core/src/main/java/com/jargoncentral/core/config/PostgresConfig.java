//package com.jargoncentral.core.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableJpaRepositories(basePackages = "com.jargoncentral.core.repository")
//@EntityScan(basePackages = "com.jargoncentral.core")
//public class PostgresConfig {
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource driver = new DriverManagerDataSource();
//        driver.setDriverClassName("org.postgresql.Driver");
//        driver.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
//        driver.setUsername("postgres");
//        driver.setPassword("");
//        return driver;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setDatabase(Database.POSTGRESQL);
//        vendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan(new String[] {"com.jargoncentral.core.model", "com.jargoncentral.core.repository", "com.jargoncentral.core.config"});
//        factory.setDataSource(dataSource());
//
//        return factory;
//    }
//
//    @Bean
//    @Autowired
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//        return txManager;
//    }
//}
