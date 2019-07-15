package com.yuanshijia.javalearn.threadpool;

import com.yuanshijia.javalearn.JavaLearnApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
public class AsyncTaskTest extends JavaLearnApplicationTests {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void doTask() {
        asyncTask.doTask();
    }

    @Test
    public void getNum() throws ExecutionException, InterruptedException {
        System.out.println(asyncTask.getNum().get());   // 阻塞调用
    }
}