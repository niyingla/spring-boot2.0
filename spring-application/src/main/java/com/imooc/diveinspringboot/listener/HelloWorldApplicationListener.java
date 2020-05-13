package com.imooc.diveinspringboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 也需要在spring.factories 设置监听
 * HelloWorld {@link ApplicationListener} 监听 {@link ContextRefreshedEvent} **重点
 *
 * @author 小马哥
 * @since 2018/5/17
 */
@Order(Ordered.HIGHEST_PRECEDENCE)//指定优先级
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 5  容器刷新事件
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("HelloWorld : " + event.getApplicationContext().getId()
                + " , timestamp : " + event.getTimestamp());
    }
}
