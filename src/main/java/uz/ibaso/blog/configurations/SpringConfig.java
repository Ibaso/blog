package uz.ibaso.blog.configurations;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@MapperScan(basePackages = "uz.ibaso.blog.mappers", sqlSessionFactoryRef = "sqlSessionFactory")


@Configuration
public class SpringConfig {
    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USER;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    @Value("${spring.datasource.driver-class-name}")
    private String DRIVER_CLASS;


    private String LOCATION_MYBATIS_MAPPERS_PATH = "classpath:db/mybatis/mapper/*/*Mapper.xml";


    @Bean(name = "dataSource")
    public DataSource dataSource() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(DRIVER_CLASS);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setPoolMaximumActiveConnections(20);
        dataSource.setPoolMaximumIdleConnections(5);
        return dataSource;
    }


    @Bean(name = "transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        /** install mappers location  */
        var allLocationMapper = new PathMatchingResourcePatternResolver().getResources(LOCATION_MYBATIS_MAPPERS_PATH);

        sessionFactory.setMapperLocations(allLocationMapper);

        /** install log mybatis  */
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(Slf4jImpl.class);
        configuration.setLogPrefix("_MYBATIS_");

        sessionFactory.setConfiguration(configuration);

        return sessionFactory.getObject();
    }
}

