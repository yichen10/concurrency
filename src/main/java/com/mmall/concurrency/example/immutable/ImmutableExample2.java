package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ImmutableExample2 {
    //基本数据类型及封装类类不能修改；String也不能，对象不能指向其他新的对象；

    private static Map<Integer,Integer> map = Maps.newHashMap();
    static {
        map.put(1,2);
        map.put(3,4);
        map = Collections.unmodifiableMap(map);
    }
    public static void main(String[] args) {
        map.put(4,5);
        //log.info("map.get(1),{}",map.get(4));
    }


}
