package com.zhengkehui.parameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author zhengkehui
 * @Date 2018/5/19 8:53
 * @Description
 */
public class BehaviorParameterization {

    public static void main(String[] args) {
        List<String> lines = Arrays.asList("spring", "node", "mkyong");
        List<String> filterList = lines.stream().filter(line -> line.startsWith("s")).collect(Collectors.toList());
        System.out.println(filterList);
        lines.sort((String a,String b) -> a.compareTo(b));
        System.out.println(lines);

    }


}
