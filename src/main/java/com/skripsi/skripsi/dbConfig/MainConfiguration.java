package com.skripsi.skripsi.dbConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
        basePackages = "com.skripsi.skripsi.repository",
        entityManagerFactoryRef = "mainEntityManager",
        transactionManagerRef = "mainTransactionManager"
)
public class MainConfiguration {
    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean mainEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mainDataSource());
        em.setPackagesToScan(
                new String[] { "com.skripsi.skripsi.model" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("spring.mainsource.ddl-auto"));
        properties.put("hibernate.dialect",
                env.getProperty("spring.jpa.database-platform"));
        properties.put("properties.hibernate.jdbc.lob.non_contextual_creation",
                env.getProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creatio"));
        properties.put("database-platform",
                env.getProperty("spring.jpa.database-platform"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean
    public DataSource mainDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("spring.jpa.database-platform"));
        dataSource.setUrl(env.getProperty("spring.mainsource.url"));
        dataSource.setUsername(env.getProperty("spring.mainsource.username"));
        dataSource.setPassword(env.getProperty("spring.mainsource.password"));
        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager mainTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                mainEntityManager().getObject());
        return transactionManager;
    }
}