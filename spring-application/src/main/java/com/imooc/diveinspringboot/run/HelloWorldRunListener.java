package com.imooc.diveinspringboot.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * HelloWorld {@link SpringApplicationRunListener}
 *
 * @author huohua
 * @since 2018/5/17
 */
public class HelloWorldRunListener implements SpringApplicationRunListener {

    /**
     * 必须使用当前参数构造
     * @param application
     * @param args
     */
    public HelloWorldRunListener(SpringApplication application, String[] args) {

    }

    /**
     * 1
     * Spring 应用刚启动
     * 对应事件 ApplicationStartingEvent
     */
    @Override
    public void starting() {
        System.out.println("HelloWorldRunListener.starting()...");
    }

    /**
     *
     * ConfigurableEnvironment 准备妥当，允许将其调整
     * 对应事件 ApplicationEnvironmentPreparedEvent
     * @param environment
     */
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    /**
     * ConfigurableApplicationContext 准备妥当，允许将其调整
     * @param context
     */
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    /**
     * 对应事件 ApplicationPreparedEvent
     * ConfigurableApplicationContext 已装载，但仍未启动
     * @param context
     */
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    /**
     * 对应事件 ApplicationStartedEvent
     * ConfigurableApplicationContext 已启动，此时 Spring Bean 已初始化完成
     * @param context
     */
    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    /**
     * 对应事件 ApplicationReadyEvent
     * Spring 应用正在运行
     * @param context
     */
    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    /**
     * 对应事件 ApplicationFailedEvent
     * Spring 应用运行失败
     * @param context
     * @param exception
     */
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
