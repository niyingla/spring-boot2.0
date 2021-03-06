package com.imooc.diveinspringboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *  Spring 应用事件引导类
 *  创建 Spring 应用上下文（ ConfigurableApplicationContext ）
 *  Web Reactive： AnnotationConfigReactiveWebServerApplicationContext
 *  Web Servlet： AnnotationConfigServletWebServerApplicationContext
 *  非 Web： AnnotationConfigApplicationContext
 *  ContextRefreshedEvent
 * Spring 应用上下文 引导类
 * 方法 getSpringFactoriesInstances
 * 利用 Spring 工厂加载机制，实例化 ApplicationContextInitializer 实现类，并排序对象集合。
 *
 * Context 和 Environment 都是根据类型推断的进行加载的
 *
 * @author huohua
 * @since 2018/5/17
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
//                .web(WebApplicationType.SERVLET)
                .run(args);

        //打印当前应用的上下文类型
        System.out.println("ConfigurableApplicationContext 类型：" + context.getClass().getName());
        //打印当前应用的Environment类型
        System.out.println("Environment 类型：" + context.getEnvironment().getClass().getName());

        // 关闭上下文
        context.close();
    }
}
