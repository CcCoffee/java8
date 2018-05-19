package com.zhengkehui.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhengkehui
 * @Date 2018/5/19 16:30
 * @Description
 */
public class TransactionTest {

    public static void main(String[] args) {
        Trader kevin = new Trader("Kevin", "Shantou");
        Trader mia = new Trader("Mia", "Heyuan");
        Trader alan = new Trader("Alan", "Heyuan");
        Trader brain = new Trader("Brian", "Guangzhou");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(kevin, 2011, 1300),
                new Transaction(kevin, 2012, 500),
                new Transaction(mia, 2011, 1100),
                new Transaction(mia, 2012, 800),
                new Transaction(alan, 2012, 900),
                new Transaction(brain, 2012, 600)
        );

        List<Transaction> list1 = transactions.stream()
                .filter((Transaction t) -> t.getYear() == 2011)
                //.sorted(Comparator.comparing((a) -> a.getValue()))
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(list1);

        List<String> list2 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list2);

        Set<Trader> list3 = transactions.stream().map(Transaction::getTrader)
                .filter((Trader a) -> a.getCity().equals("Heyuan"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toSet());
        System.out.println(list3);

        boolean shantou = transactions.stream().map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Shantou"));
        System.out.println(shantou);

        Integer sum = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Heyuan"))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println(sum);

        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Heyuan"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        Optional<Integer> max = transactions.stream().map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(max.orElse(-1));

        Optional<Integer> min = transactions.stream().map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println(min.orElse(-1));
    }

    static class Trader{
        private final String name;
        private final String city;
        public Trader(String name,String city){
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Trader{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
    static class Transaction{
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return trader;
        }

        public int getYear() {
            return year;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "trader=" + trader +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }
}
