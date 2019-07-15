package com.yuanshijia.javalearn.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Random;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
@Component
public class AsyncTask {
    /**
     * 使用默认的线程池
     */
    @Async
    public void doTask(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }

    /**
     * 使用默认的线程池并返回参数
     */
    @Async
    public ListenableFuture<String> getNum(){
        return new AsyncResult<>("return value =" + new Random().nextInt());
    }
}
