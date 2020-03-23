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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-06 09:38
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "MYSQL_ENTITY_MANAGER_FACTORY",
    transactionManagerRef = "MYSQL_PLATFORM_TX_MANAGER",
    basePackages = {"com.example.demo.dao.mysql.repository"})
public class MysqlConfig {
  public static final String MYSQL_JPA_PROPS = "demo.datasource.mysql.jpa";
  public static final String MYSQL_DATASOURCE = "demo.datasource.mysql";
  public static final String MYSQL_PERSISTENCE_UNIT = "MYSQL_PERSISTENCE_UNIT";
  public static final String MYSQL_ENTITY_MANAGER = "MYSQL_ENTITY_MANAGER";
  public static final String MYSQL_ENTITY_MANAGER_FACTORY = "MYSQL_ENTITY_MANAGER_FACTORY";
  public static final String MYSQL_PLATFORM_TX_MANAGER = "MYSQL_PLATFORM_TX_MANAGER";

  @Bean(name = MYSQL_JPA_PROPS)
  @Primary
  @ConfigurationProperties(prefix = MYSQL_JPA_PROPS)
  public JpaProperties mysqlJpaProperties() {
    return new JpaProperties();
  }

  @Bean
  @Primary
  @ConfigurationProperties(prefix = MYSQL_DATASOURCE)
  public DataSourceProperties mysqlDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean(name = MYSQL_DATASOURCE)
  @Primary
  public DataSource mysqlDataSource() {
    return mysqlDataSourceProperties().initializeDataSourceBuilder().build();
  }

  @Bean(name = MYSQL_ENTITY_MANAGER)
  @Primary
  public EntityManager mysqlEntityManager(
      @Qualifier(MYSQL_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
    return entityManagerFactory.createEntityManager();
  }

  @Bean(name = MYSQL_ENTITY_MANAGER_FACTORY)
  @Primary
  public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
      EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(mysqlDataSource())
        .packages("com.example.demo.dao.mysql.entity")
        .persistenceUnit(MYSQL_PERSISTENCE_UNIT)
        .properties(mysqlJpaProperties().getProperties())
        .build();
  }

  @Bean(name = MYSQL_PLATFORM_TX_MANAGER)
  @Primary
  public PlatformTransactionManager mysqlPlatformTransactionManager(
      @Qualifier(MYSQL_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}
