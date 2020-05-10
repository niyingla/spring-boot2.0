package com.imooc.diveinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringApplication} 引导类
 *
 * 通过堆栈推倒启动mian方法 deduceMainApplicationClass
 * new RuntimeException()).getStackTrace() 可以获取堆栈 堆栈可以拿到外层调用方法
 *
 *
 * deduceEnvironmentClass 判断环境类型 SERVLET、REACTIVE、无
 * @author 小马哥
 * @since 2018/5/16
 */
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
//        SpringApplication.run(ApplicationConfiguration.class,args);

        Set<String> sources = new HashSet();
        // 配置Class 名称
        sources.add(ApplicationConfiguration.class.getName());
        SpringApplication springApplication = new SpringApplication();
        // 方法里添加参数来配置源
        // 也可以自定义java配置，可以看出，传入的class，
        // 不一定是运行类的class，也可以是自己定义的class，
        // 只要有SpringBootApplication注解即可。
        springApplication.setSources(sources);
        //手动设置应用类型
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);

    }

    /**
     * 注解所在对象也会被管理成bean
     */
    @SpringBootApplication
    public static class ApplicationConfiguration {

    }

}
