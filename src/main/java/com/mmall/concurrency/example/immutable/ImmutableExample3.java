package com.mmall.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
public class ImmutableExample3 {
    //基本数据类型及封装类类不能修改；String也不能，对象不能指向其他新的对象；

    private static Map<Integer,Integer> map = ImmutableMap.of(1,2,3,4);

    private static List<Integer> list = ImmutableList.of(1,2);

    public static void main(String[] args) {
        map.put(4,5);
        log.info("map.get(1),{}",map.get(4));
    }


}
