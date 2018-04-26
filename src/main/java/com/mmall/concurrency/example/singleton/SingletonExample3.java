package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotThreadSafe;

/**
 * 双重锁检查；
 */
@NotThreadSafe
public class SingletonExample3 {

    private SingletonExample3() {

    }
    private static SingletonExample3 instance = null;
    // 1.分配内存对象；memony = allocate();
    // 2.初始化对象；
    // 3.instance=memony设置instance指向刚分配的内存；
    public static SingletonExample3 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample3.class) {
                if (instance == null) {
                  instance = new SingletonExample3();//指令重排；线程不安全；
                  return instance;
                }
            }
        }
        return instance;
    }
}
