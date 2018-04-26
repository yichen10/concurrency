package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotThreadSafe;

/**
 * 饿汉模式；
 */
@NotThreadSafe
public class SingletonExample2 {

    private SingletonExample2() {
    }
    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }
}
