package com.example.demo.config.ds;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-06 09:38
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "POSTGRE_ENTITY_MANAGER_FACTORY",
        transactionManagerRef = "POSTGRE_PLATFORM_TX_MANAGER",
        basePackages = {"com.example.demo.dao.postgre.repository"})
@EnableTransactionManagement
public class PostgreConfig {
    public static final String POSTGRE_JPA_PROPS = "demo.datasource.postgre.jpa";
    public static final String POSTGRE_DATASOURCE = "demo.datasource.postgre";
    public static final String POSTGRE_PERSISTENCE_UNIT = "POSTGRE_PERSISTENCE_UNIT";
    public static final String POSTGRE_ENTITY_MANAGER = "POSTGRE_ENTITY_MANAGER";
    public static final String POSTGRE_ENTITY_MANAGER_FACTORY = "POSTGRE_ENTITY_MANAGER_FACTORY";
    public static final String POSTGRE_PLATFORM_TX_MANAGER = "POSTGRE_PLATFORM_TX_MANAGER";

    @Bean(name = POSTGRE_JPA_PROPS)
    @ConfigurationProperties(POSTGRE_JPA_PROPS)
    public JpaProperties postgreJpaProperties() {
        JpaProperties jpaProperties = new JpaProperties();
        jpaProperties.setDatabase(Database.MYSQL);
        return jpaProperties;
    }

    @Bean
    @ConfigurationProperties(prefix = POSTGRE_DATASOURCE)
    public DataSourceProperties postgreDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = POSTGRE_DATASOURCE)
    public DataSource postgreDataSource() {
        return postgreDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = POSTGRE_ENTITY_MANAGER)
    public EntityManager postgreEntityManager(
            @Qualifier(POSTGRE_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean(name = POSTGRE_ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean postgreEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(postgreDataSource())
                .packages("com.example.demo.dao.postgre.entity")
                .persistenceUnit(POSTGRE_PERSISTENCE_UNIT)
                .properties(postgreJpaProperties().getProperties())
                .build();
    }

    @Bean(name = POSTGRE_PLATFORM_TX_MANAGER)
    public PlatformTransactionManager postgrePlatformTransactionManager(
            @Qualifier(POSTGRE_ENTITY_MANAGER_FACTORY) EntityManagerFactory postgreEntityManagerFactory) {
        return new JpaTransactionManager(postgreEntityManagerFactory);
    }
}
