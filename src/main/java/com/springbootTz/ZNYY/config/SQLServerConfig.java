package com.springbootTz.ZNYY.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

@Configuration
public class SQLServerConfig {
    private static final Logger logger = LoggerFactory.getLogger(SQLServerConfig.class);

    @Bean(name = "sqlserverDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sqlserver")
    public DataSource dataSource() {
        logger.info("初始化SQL Server数据源...");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlserverTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("sqlserverDataSource") DataSource dataSource) {
        logger.info("初始化SQL Server事务管理器...");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlserverSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("sqlserverDataSource") DataSource dataSource)
            throws Exception {
        logger.info("初始化SQL Server SqlSessionFactory...");
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "sqlserverSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlserverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        logger.info("初始化SQL Server SqlSessionTemplate...");
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}