package com.imooc.diveinspringboot.bootstrap;

import com.imooc.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 系统属性条件引导类
 * 指定@Conditional子注解 value为约束条件类
 * @author huohua
 * @since 2018/5/15
 */
public class ConditionalOnSystemPropertyBootstrap {

    /**
     * 指定好运行参数 -Duser.name=Mercy
     * @return
     */
    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "Mercy")
    public String helloWorld() {
        return "Hello,World huohua";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        // 通过名称和类型获取 helloWorld Bean
        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
