package cn.piao888.dynamic.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

/**
 * descrption: 多数据源的选择
 * authohr: wangji
 * date: 2017-08-21 10:32
 */
public class MultipleDataSourceToChoose extends AbstractRoutingDataSource {
    public MultipleDataSourceToChoose(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources)
    {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        //在初始化的时候 会将targetDataSources中的 数据，放入到resolvedDataSources，
        //重写的determineCurrentLookupKey 会在AbstractRoutingDataSource.determineTargetDataSource（）方法中调用 ，
        // 然后 根据获取到的key 从 resolvedDataSources 集合中取出数据源
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    /**
     * @desction: 根据Key获取数据源的信息，上层抽象函数的钩子
     * AbstractRoutingDataSource 重写了 DateSoure的 getConnection 方法
     *                              getConnection 会调用determineTargetDataSource（）方法
     *                              determineTargetDataSource方法 会先去 获取determineCurrentLookupKey方法
     *                              而这个方法是需要自己去重写实现的
     *             重写思路，为了干啥？
     *                  根据当前线程，获取的方法标记的主从库信息 ，返回给给 determineTargetDataSource方法
     *                  实际上 返回的是枚举包中的 主从 枚举信息
     * @author: wangji
     * @date: 2017/8/21
     * @param:
     * @return:  DataSourceType.java  (返回这个枚举信息) 他从 方法的注解中定义
     */
    @Override
    protected Object determineCurrentLookupKey() {
        //通过返回的key 来从resolvedDataSources map中查找对应的数据源
        //技巧：
        //可以根据HandlerDataSource.getDataSource()方法 来完善更加灵活的多数据源方法
        return HandlerDataSource.getDataSource();
    }
}