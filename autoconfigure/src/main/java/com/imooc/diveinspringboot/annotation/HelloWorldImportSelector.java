package com.imooc.diveinspringboot.annotation;

import com.imooc.diveinspringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorld {@link ImportSelector} 实现
 * 实现了 ImportSelector  会自动导入selectImports返回的配置类
 * @author huohua
 * @since 2018/5/14
 */
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //返回配置类的类名  会自动加载导入配置（可以是多个）
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
