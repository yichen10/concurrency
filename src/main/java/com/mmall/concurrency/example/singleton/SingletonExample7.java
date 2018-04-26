package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 枚举模式创建；
 *
 */
@ThreadSafe
@Slf4j
public class SingletonExample7 {

    private SingletonExample7() {
    }

    public SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }
    private enum Singleton {
        INSTANCE;
        private SingletonExample7 singleton;

        Singleton (){
            singleton = new SingletonExample7();
        }
        public SingletonExample7 getSingleton(){
            return singleton;
        }
    }

}
