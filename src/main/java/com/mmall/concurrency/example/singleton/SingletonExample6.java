package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉模式，单粒在类转载时创建；
 *
 */
@ThreadSafe
@Slf4j
public class SingletonExample6 {

    private SingletonExample6() {
    }
    // 需要注意instance变量与构造块的顺序；instance变量要在前面；
    private static SingletonExample6 instance = null;
    static {
        instance = new SingletonExample6();
    }

    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        log.info("hashcode:{}",getInstance().hashCode());
        log.info("hashcode:{}",getInstance().hashCode());
    }
}
