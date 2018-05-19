package com.zhengkehui.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author zhengkehui
 * @Date 2018/5/19 15:49
 * @Description
 */
public class Stream {

    public static void main(String[] args) {
        testReduce();
    }

    private static void testReduce() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        Optional<Integer> reduce = numbers1.stream().reduce((a,b) -> a + b);
        Optional<Integer> reduce1 = numbers1.stream().reduce(Integer::sum);
        int sum = numbers1.stream().reduce(100,Integer::sum);
        System.out.println(reduce.orElse(-1));
        System.out.println(reduce1.orElse(-1));
        System.out.println(sum);
    }

    private static void testMatch() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        System.out.println(numbers1.stream().anyMatch(i -> i == 1));
    }

    private static void testMap() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> collect = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
