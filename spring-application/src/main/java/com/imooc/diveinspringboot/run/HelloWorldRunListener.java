package com.imooc.diveinspringboot.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * HelloWorld {@link SpringApplicationRunListener}
 *
 * @author 小马哥
 * @since 2018/5/17
 */
public class HelloWorldRunListener implements SpringApplicationRunListener {

    public HelloWorldRunListener(SpringApplication application, String[] args) {

    }

    /**
     * 1
     * Spring 应用刚启动
     */
    @Override
    public void starting() {
        System.out.println("HelloWorldRunListener.starting()...");
    }

    /**
     * ConfigurableEnvironment 准备妥当，允许将其调整
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
     * ConfigurableApplicationContext 已装载，但仍未启动
     * @param context
     */
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    /**
     * ConfigurableApplicationContext 已启动，此时 Spring Bean 已初始化完成
     * @param context
     */
    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    /**
     * Spring 应用正在运行
     * @param context
     */
    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    /**
     * Spring 应用运行失败
     * @param context
     * @param exception
     */
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
