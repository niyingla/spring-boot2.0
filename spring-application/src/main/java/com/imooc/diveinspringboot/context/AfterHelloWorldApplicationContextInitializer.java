package com.imooc.diveinspringboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * spring.factories 文件中指定加载当前初始化器
 * After HelloWorldApplicationContextInitializer
 * 加载应用上下文初始器
 * @author huohua
 * @since 2018/5/17
 */
public class AfterHelloWorldApplicationContextInitializer implements ApplicationContextInitializer, Ordered {

    /**
     * 4
     * 在容器刷新之前调用该类的 initialize 方法
     * @param applicationContext
     */
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("After application.id = " + applicationContext.getId());
    }

    /**
     * 指定其拥有最高的排序级别 （也就是加载顺序 越小越先）
     * @return
     */
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
