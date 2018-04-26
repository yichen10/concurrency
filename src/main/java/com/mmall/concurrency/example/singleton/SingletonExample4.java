package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotRecommend;
import com.mmall.concurrency.annotations.NotThreadSafe;
import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * 使用static synchronized，单例在第一次使用时创建；
 */
@ThreadSafe
@NotRecommend
public class SingletonExample4 {

    private SingletonExample4() {
    }
    private static SingletonExample4 instance = null;

    public synchronized static SingletonExample4 getInstance() {
        if (instance == null) {
            instance = new SingletonExample4();
        }
        return instance;
    }
}
