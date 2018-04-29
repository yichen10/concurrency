package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wang on 2018/4/29.
 */
@Slf4j
public class CountDownLatchExample2 {
    private final static int threadCount = 30;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            int threadNum = i;
            executorService.execute(() -> {
                try {
                    print(threadNum);
                } catch (Exception e) {
                    log.error("exception",e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("finished");
        executorService.shutdown();

    }

    private static void print (int threaddNum) throws Exception{
        Thread.sleep(1000);
        log.info("thread{}",threaddNum);
       // Thread.sleep(1000);
    }


}
