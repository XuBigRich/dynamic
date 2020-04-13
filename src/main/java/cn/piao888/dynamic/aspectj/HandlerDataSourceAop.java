package cn.piao888.dynamic.aspectj;

import cn.piao888.dynamic.annotation.DS;
import cn.piao888.dynamic.datasource.HandlerDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * descrption: 使用AOP拦截特定的注解去动态的切换数据源
 * authohr: wangji
 * date: 2017-08-21 10:42
 */
@Aspect
@Component
@Order(1)
public class HandlerDataSourceAop {
    //@within在类上设置
    //@annotation在方法上进行设置
    @Pointcut("@annotation(cn.piao888.dynamic.annotation.DS)"
            + "|| @within(cn.piao888.dynamic.annotation.DS)")
    public void pointcut() {}

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint)
    {
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        DS annotationClass = method.getAnnotation(DS.class);//获取方法上的注解
        if(annotationClass == null){
            annotationClass = joinPoint.getTarget().getClass().getAnnotation(DS.class);//获取类上面的注解
            if(annotationClass == null) return;
        }
        //获取注解上的数据源的值的信息
        String dataSourceKey = annotationClass.value().name();
        if(dataSourceKey !=null){
            //给当前的执行SQL的操作设置特殊的数据源的信息
            HandlerDataSource.putDataSource(dataSourceKey);
        }
    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        //清理掉当前设置的数据源，让默认的数据源不受影响
        HandlerDataSource.clear();
    }

}