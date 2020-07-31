package com.imooc.diveinspringboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**

 *
 * ApplicationContext 被初始化或刷新时，该事件被发布。
 * 这也可以在ConfigurableApplicationContext接口中使用 refresh() 方法来发生。此处的初始化是指：
 * 所有的Bean被成功装载，后处理Bean被检测并激活，所有Singleton Bean 被预实例化，ApplicationContext容器已就绪可用
 *
 * ContextStartedEvent
 *
 * 当使用 ConfigurableApplicationContext （ApplicationContext子接口）接口中的 start() 方法启动 
 * ApplicationContext 时，该事件被发布。你可以调查你的数据库，或者你可以在接受到这个事件后重启任何停止的应用程序。
 *
 * ContextStoppedEvent
 *
 * 当使用 ConfigurableApplicationContext 接口中的 stop() 停止 ApplicationContext 时，
 * 发布这个事件。你可以在接受到这个事件后做必要的清理的工作。
 *
 * ContextClosedEvent
 *
 * 当使用 ConfigurableApplicationContext 接口中的 close() 方法关闭 ApplicationContext 时，
 * 该事件被发布。一个已关闭的上下文到达生命周期末端；它不能被刷新或重启。
 *
 * RequestHandledEvent
 *
 * 这是一个 web-specific 事件，告诉所有 bean HTTP 请求已经被服务。只能应用于使用DispatcherServlet的Web应用。
 * 在使用Spring作为前端的MVC控制器时，当Spring处理用户请求结束后，系统会自动触发该事件。
 *
 * Spring 应用事件
 *      普通应用事件：   ApplicationEvent
 *      应用上下文事件： ApplicationContextEvent
 * Spring 应用监听器
 *      接口编程模型：   ApplicationListener
 *      注解编程模型：   @EventListener
 *
 *     注解模式 （同一个事件可以多个监听）
 *     @EventListener
 *     public void listenHello(HelloEvent event)
 */
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        // 创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听到事件: " + event);
        });

        //启动上下文
        context.refresh();
        // 发送事件 默认是 ApplicationContextEvent
        context.publishEvent("HelloWorld");
        context.publishEvent("2018");
        context.publishEvent(new ApplicationEvent("小马哥") {});

        // 关闭上下文
        context.close();
    }
}
