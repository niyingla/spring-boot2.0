package com.imooc.diveinspringboot.bootstrap;

import com.imooc.diveinspringboot.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link EnableHelloWorld} 引导类
 * 一般的@Enable*** 内部包含
 * @Import(****ImportSelector.class)
 * 这个导入类实现了ImportSelector 然后加载selectImports返回的类
 * @author 小马哥
 * @since 2018/5/14
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
