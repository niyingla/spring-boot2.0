package com.imooc.spring.web.servlet.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Hello World 异步 {@link RestController}
 *
 * @author huohua
 * @since 2018/6/4
 */
@RestController
@EnableScheduling
public class HelloWorldAsyncController {

    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);

    // 超时随机数
    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException { // 定时操作
        DeferredResult<String> result = null;
        do {
            result = queue.take();
            // 随机超时时间
            long timeout = random.nextInt(100);
            // 模拟等待时间，RPC 或者 DB 查询
            Thread.sleep(timeout);
            // 计算结果
            result.setResult("Hello,World");
            println("执行计算结果，消耗：" + timeout + " ms.");
        } while (result != null);
    }

    @GetMapping("/completion-stage")
    public CompletionStage<String> completionStage(){
        final long startTime = System.currentTimeMillis();

        println("Hello,World");

        return CompletableFuture.supplyAsync(()->{
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗：" + costTime + " ms.");
            return "Hello,World"; // 异步执行结果
        });
    }

    @GetMapping("/callable-hello-world")
    public Callable<String> callableHelloWorld() {
        final long startTime = System.currentTimeMillis();

        println("Hello,World");

        return () -> {
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗：" + costTime + " ms.");
            return "Hello,World";
        };
    }

    /**
     * 异步操作的结果同步返回给前端
     * 当一个请求到达API接口，如果该API接口的return返回值是DeferredResult，
     * 在没有超时或者DeferredResult对象设置setResult时，接口不会返回，
     * 但是Servlet容器线程会结束，DeferredResult另起线程来进行结果处理(即这种操作提升了服务短时间的吞吐能力)，
     * 并setResult，如此以来这个请求不会占用服务连接池太久，如果超时或设置setResult，接口会立即返回。
     *
     * @return
     */
    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld() {
        DeferredResult<String> result = new DeferredResult<>(50L);
//        result.setResult("Hello,World");
        // 入队操作
//        queue.offer(result);
        println("Hello,World");
        result.onCompletion(() -> {
            //可以理解为finally 总会跟随线程完成
            println("执行结束");
        });

        result.onTimeout(() -> {
            //可以理解为异常 所以另起一个线程
            println("执行超时");
        });

        return result;
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController[" + threadName + "]: " + object);
    }

}
