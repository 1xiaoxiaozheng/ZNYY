package com.springbootTz.ZNYY.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {

    @Configuration
    @MapperScan(basePackages = "com.springbootTz.ZNYY.mapper.postgresql", sqlSessionFactoryRef = "postgresSqlSessionFactory")
    public class PostgresConfig {
        @Primary
        @Bean(name = "postgresTransactionManager")
        public PlatformTransactionManager postgresTransactionManager(
                @Qualifier("postgresDataSource") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Primary
        @Bean(name = "postgresSqlSessionFactory")
        public SqlSessionFactory postgresSqlSessionFactory(@Qualifier("postgresDataSource") DataSource dataSource)
                throws Exception {
            MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            return bean.getObject();
        }

        @Primary
        @Bean(name = "postgresSqlSessionTemplate")
        public SqlSessionTemplate postgresSqlSessionTemplate(
                @Qualifier("postgresSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    @Configuration
    @MapperScan(basePackages = "com.springbootTz.ZNYY.mapper.oracle", sqlSessionFactoryRef = "oracleSqlSessionFactory")
    public class OracleConfig {
        @Bean(name = "oracleTransactionManager")
        public PlatformTransactionManager oracleTransactionManager(
                @Qualifier("oracleDataSource") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Bean(name = "oracleSqlSessionFactory")
        public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource dataSource)
                throws Exception {
            MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            return bean.getObject();
        }

        @Bean(name = "oracleSqlSessionTemplate")
        public SqlSessionTemplate oracleSqlSessionTemplate(
                @Qualifier("oracleSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    @Configuration
    @MapperScan(basePackages = "com.springbootTz.ZNYY.Equipment.mapper.seeyon", sqlSessionFactoryRef = "sqlserverSqlSessionFactory")
    public class SQLServerConfig {
        @Bean(name = "sqlserverTransactionManager")
        public PlatformTransactionManager sqlserverTransactionManager(
                @Qualifier("sqlserverDataSource") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Bean(name = "sqlserverSqlSessionFactory")
        public SqlSessionFactory sqlserverSqlSessionFactory(@Qualifier("sqlserverDataSource") DataSource dataSource)
                throws Exception {
            MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            return bean.getObject();
        }

        @Bean(name = "sqlserverSqlSessionTemplate")
        public SqlSessionTemplate sqlserverSqlSessionTemplate(
                @Qualifier("sqlserverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    @Configuration
    @MapperScan(basePackages = "com.springbootTz.ZNYY.Equipment.mapper.znyy", sqlSessionFactoryRef = "oracleSqlSessionFactory")
    public class EquipmentOracleConfig {
        @Bean(name = "equipmentOracleTransactionManager")
        public PlatformTransactionManager equipmentOracleTransactionManager(
                @Qualifier("oracleDataSource") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }
    }
}