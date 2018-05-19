package com.zhengkehui.lambda;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;

/**
 * @Author zhengkehui
 * @Date 2018/5/19 9:27
 * @Description
 */
public class Lambda {

    public static void main(String[] args) {
        //a为final，或等效于final。不可改变值
        int a = 33;
        Runnable r = () -> System.out.println(a);
        new Thread(r).start();
    }
}
