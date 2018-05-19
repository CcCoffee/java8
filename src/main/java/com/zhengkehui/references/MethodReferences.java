package com.zhengkehui.references;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Author zhengkehui
 * @Date 2018/5/19 11:13
 * @Description
 */
public class MethodReferences {

    public static void main(String[] args) {
        testComposite();
    }

    private static void testComposite() {
        List<Apple> apples = Arrays.asList(new Apple(34d, 44d), new Apple(45d, 55d),new Apple(45d, 22d), new Apple(11d, 33d));
        Predicate<Apple> weightPredicate = (Apple a) -> a.getWeight() > 40d;
        weightPredicate.and((Apple a) -> a.getPrice() < 30d);
        List<Apple> collectList = apples.stream().filter(weightPredicate).collect(Collectors.toList());
        System.out.println(collectList);
    }

    private static void testChain() {
        List<Apple> apples = Arrays.asList(new Apple(34d, 44d), new Apple(45d, 55d),new Apple(45d, 22d), new Apple(11d, 33d));
        apples.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Comparator.comparing(Apple::getPrice)));
        System.out.println(apples);
    }

    private static void testNew() {
        BiFunction<Double,Double,Apple> function = Apple::new;
        System.out.println(function.apply(22d,33d));
        Supplier<Apple> supplier = Apple::new;
        System.out.println(supplier.get());
    }

    static class Apple{

        private double weight;
        private double price;

        public Apple(){

        }

        public Apple(Double weight,Double price){
            this.weight = weight;
            this.price = price;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }
}
