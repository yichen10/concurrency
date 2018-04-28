package com.mmall.concurrency.example.immutable;

import java.util.HashMap;
import java.util.Map;

public class ImmutableExample1 {
    //基本数据类型及封装类类不能修改；String也不能，对象不能指向其他新的对象；
    private static final Integer a = 10;

    private static final Long b = 10l;

    private static final String name = "a";

    private static final Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {

    }
    public void update () {
//        a = 1;
//        b = 2;
//        name = ""
        map.put(1,2);

    }

}
