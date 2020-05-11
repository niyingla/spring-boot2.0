package com.imooc.diveinspringboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring 应用上下文 引导类
 * 方法 getSpringFactoriesInstances
 * 利用 Spring 工厂加载机制，实例化 ApplicationContextInitializer 实现类，并排序对象集合。
 *
 * @author 小马哥
 * @since 2018/5/17
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
//                .web(WebApplicationType.NONE)
                .run(args);

        System.out.println("ConfigurableApplicationContext 类型：" + context.getClass().getName());
        System.out.println("Environment 类型：" + context.getEnvironment().getClass().getName());

        // 关闭上下文
        context.close();
    }
}
