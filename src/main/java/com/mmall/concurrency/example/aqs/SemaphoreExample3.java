package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by wang on 2018/4/29.
 */
@Slf4j
public class SemaphoreExample3 {
    private final static int threadCount = 20;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            int num = i;
            executorService.execute(() -> {
                try {
                    if (semaphore.tryAcquire()) {
                        test(num);
                        semaphore.release();
                    }
                } catch (Exception e) {
                    log.error("error",e);
                }
            });
        }
        log.info("finish");
        executorService.shutdown();
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
