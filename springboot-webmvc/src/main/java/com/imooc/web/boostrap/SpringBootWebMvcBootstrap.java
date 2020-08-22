package com.imooc.web.boostrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.io.File;

/**
 * Spring Boot Web MVC 引导类
 *
 * web 自动配置类 DispatcherServletAutoConfiguration
 * 通过dispatcherServletRegistration 注入对象
 * dispatcherServletRegistration 实现了ServletContextInitializer
 * 启动后自动执行
 *
 * SpringServletContainerInitializer 配合 @HandlesTypes
 * onStartup加入初始化类（排除接口和抽象类）
 *
 * AbstractAnnotationConfigDispatcherServletInitializer
 * 加载初始化注册类
 *
 * @author huohua
 * @since 2018/5/21
 */
@SpringBootApplication(scanBasePackages = "com.imooc.web")
public class SpringBootWebMvcBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcBootstrap.class, args);
    }

}
