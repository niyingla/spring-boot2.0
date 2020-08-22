package com.imooc.diveinspringboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * 系统属性条件判断
 *
 * @author huohua
 * @since 2018/5/15
 */
public class OnSystemPropertyCondition implements Condition {

    /**
     * 指定好运行参数 -Duser.name=Mercy
     * 判断匹配方法
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取类上的属性
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        //转成String
        String propertyName = String.valueOf(attributes.get("name"));
        //转成String
        String propertyValue = String.valueOf(attributes.get("value"));
        //JVM中的系统属性
        String javaPropertyValue = System.getProperty(propertyName);
        //判断注解属性是否和jvm属性一致
        return propertyValue.equals(javaPropertyValue);
    }
}
