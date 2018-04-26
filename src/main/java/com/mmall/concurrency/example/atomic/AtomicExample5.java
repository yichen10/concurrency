package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    public volatile int count = 0;

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();
        if (updater.compareAndSet(example5,0,100)) {
            System.out.println("succ1"+example5.getCount());
        }
        if (updater.compareAndSet(example5,20,120)) {
            System.out.println("succ2"+example5.getCount());
        } else {
            System.out.println("faild" + example5.getCount());
        }

    }



}
