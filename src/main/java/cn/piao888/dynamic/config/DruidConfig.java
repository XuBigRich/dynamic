package cn.piao888.dynamic.config;

import cn.piao888.dynamic.datasource.MultipleDataSourceToChoose;
import cn.piao888.dynamic.enums.DataSourceType;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * druid 配置多数据源
 * https://www.jianshu.com/p/b2f818b742a2  多数据源 教学
 *
 * @author ruoyi
 */
@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        //建立一个Druid数据源
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave")
//    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = "enabled", havingValue = "true")
    public DataSource slaveDataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    /***
     * 将动态数据源实现类加载到spring上下文容器中
     * @param masterDataSource 主数据源
     * @param slaveDataSource   辅助数据源
     * @return 动态数据源选择类的实例 以供后续选择数据源的时候 调用方法
     */
    @Bean(name = "dynamicDataSource")
    @Primary
    public MultipleDataSourceToChoose dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        // 配置多数据源 druid 是最后装载进去的 现在一个数据源一个druid
        targetDataSources.put(DataSourceType.MASTER.name(), masterDataSource);
        targetDataSources.put(DataSourceType.SLAVE.name(), slaveDataSource);
        //将多数据源信息放入 ioc容器的 dynamicDataSource 对象中  通过aop 的注解 判断使用哪一个数据源
        return new MultipleDataSourceToChoose(masterDataSource, targetDataSources);
    }
}
