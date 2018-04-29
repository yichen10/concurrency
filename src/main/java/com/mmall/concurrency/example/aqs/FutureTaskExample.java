package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by wang on 2018/4/29.
 * 使用FutureTask来接收线程执行的结果，比使用Future方便一些；在FutureTask直接写Callable匿名函数
 * 可以随时用一个线程定义FutureTask开始执行。
 */
@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws Exception{
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });
        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result:{}",result);
    }
}
