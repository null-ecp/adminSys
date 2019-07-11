package com.weison.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.weison.util.JDBCUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * spring配置类
 */
@Configuration
// 开启注解事务支持
@EnableTransactionManagement
public class configuration {

    /**
     * 数据库连接池对象
     * @return
     */
    @Bean(name = "datasource", autowire = Autowire.BY_NAME)
    public DataSource createdataSource(){
        return JDBCUtils.getDataSource();
    }

    /**
     * SPring 事务控制 对象
     * @return
     */
    @Bean(name = "transactionManager", autowire = Autowire.BY_TYPE)
    public DataSourceTransactionManager createTransactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(createdataSource());
        return transactionManager;
    }


    /**
     * mybatis 工厂对象
     * @return
     */
    @Bean(name = "sqlSessionFactory", autowire = Autowire.BY_TYPE)
    public SqlSessionFactoryBean createSqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(createdataSource());

        // 配置分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true");// 分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("reasonable", "true");// 页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("supportMethodsArguments", "true");// 支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("helperDialect","oracle"); // 数据库方言
        pageInterceptor.setProperties(properties);

        // 添加插件
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
        return sqlSessionFactoryBean;
    }

    /**
     * 注解开启扫描包
     * @return
     */
    @Bean(name = "mapperScanner", autowire = Autowire.BY_TYPE)
    public MapperScannerConfigurer creteMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.weison.dao");
        return mapperScannerConfigurer;
    }
}
