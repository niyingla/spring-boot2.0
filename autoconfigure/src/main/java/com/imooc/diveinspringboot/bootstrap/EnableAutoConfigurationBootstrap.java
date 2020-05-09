package com.imooc.diveinspringboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link EnableAutoConfiguration} 引导类
 *
 * @author 小马哥
 * @since 2018/5/15
 */

// @ConditionalOnClass ： classpath中存在该类时起效
// @ConditionalOnMissingClass ： classpath中不存在该类时起效
// @ConditionalOnBean ： DI容器中存在该类型Bean时起效
// @ConditionalOnMissingBean ： DI容器中不存在该类型Bean时起效
// @ConditionalOnSingleCandidate ： DI容器中该类型Bean只有一个或@Primary的只有一个时起效
// @ConditionalOnExpression ： SpEL表达式结果为true时
// @ConditionalOnProperty ： 参数设置或者值一致时起效
// @ConditionalOnResource ： 指定的文件存在时起效
// @ConditionalOnJndi ： 指定的JNDI存在时起效
// @ConditionalOnJava ： 指定的Java版本存在时起效
// @ConditionalOnWebApplication ： Web应用环境下起效
// @ConditionalOnNotWebApplication ： 非Web应用环境下起效
    
// 也可以通过 spring.factories文件的
// org.springframework.boot.autoconfigure.EnableAutoConfiguration 设置配置类
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();

    }
}
