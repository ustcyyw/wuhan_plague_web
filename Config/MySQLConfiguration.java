package com.ustcyyw.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Time : 2020年1月25日14:44:07
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : MySQL 配置类
 */

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef ="plagueEntityManagerFactory",
        transactionManagerRef = "plagueTransactionManager",
        basePackages = "com.ustcyyw.Dao.repository"
)
public class MySQLConfiguration {
    @Value("${spring.datasource.url}")
    private String dbURL;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;

    @Bean(name = "plagueDB")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(this.dbURL);
        dataSource.setPassword(this.password);
        dataSource.setUsername(this.username);
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setInitialSize(this.initialSize);
        dataSource.setMinIdle(this.minIdle);
        dataSource.setMaxActive(this.maxActive);
        dataSource.setMaxWait(this.maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        dataSource.setTestOnBorrow(this.testOnBorrow);
        dataSource.setTestOnReturn(this.testOnReturn);
        dataSource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        dataSource.setTestWhileIdle(this.testWhileIdle);
        dataSource.setPoolPreparedStatements(this.poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
        try{
            dataSource.setFilters(this.filters);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        dataSource.setConnectionProperties(this.connectionProperties);
        return dataSource;
    }

    @Bean(name = "plagueEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean deviceEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("plagueDB") DataSource dataSource
    ){
        return builder
                .dataSource(dataSource)
                .packages("com.ustcyyw.Dao.entity")
                .persistenceUnit("plague")
                .build();
    }

    @Bean(name = "plagueTransactionManager")
    public PlatformTransactionManager reviewTransactionManager(
            @Qualifier("plagueEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
