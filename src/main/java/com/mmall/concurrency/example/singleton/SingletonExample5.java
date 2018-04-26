package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * 双重锁检查；
 * x使用volatile修饰变量，消除jvm指令重排；
 */
@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5() {

    }
    private volatile static SingletonExample5 instance = null;
    // 1.分配内存对象；memony = allocate();
    // 2.初始化对象；
    // 3.instance=memony设置instance指向刚分配的内存；
    public static SingletonExample5 getInstance() {
        if (instance == null) {                     // 线程B
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                  instance = new SingletonExample5();//线程A，当另外一个线程B判断instance时，
                                                    // A刚完成初始化1，3步骤，由于指令重排，2步骤还没开始；
                  return instance;
                }
            }
        }
        return instance;
    }
}
