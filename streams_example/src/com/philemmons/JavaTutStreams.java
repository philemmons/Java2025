package com.philemmons;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class JavaTutStreams {

    public static void main(String[] args) {
        List<Integer> oneTo10 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        List<Integer> squares = oneTo10.stream().map(x -> x * x).collect(Collectors.toList());

        for (Integer x : squares) {
            System.out.println(x);
        }

        List<Integer> evens = oneTo10.stream().filter(x -> (x % 2) == 0).collect(Collectors.toList());

        for (Integer x : evens) {
            System.out.println(x);
        }

        IntStream limitTo5 = IntStream.range(1, 10).limit(5);

        limitTo5.forEach(System.out::println);

        int multiAll = IntStream.range(1, 5).reduce(1, (x, y) -> x * y);

        System.out.println(multiAll);

        DoubleStream stream = IntStream.range(1, 5).mapToDouble(i -> i);

        stream.forEach(System.out::println);

        IntSummaryStatistics iStats = IntStream.range(1, 10).summaryStatistics();
        
        //System.out.println(iStats);
        System.out.println(iStats.getCount());
        System.out.println(iStats.getAverage());
        System.out.println(iStats.getSum());
        System.out.println(iStats.getMin());
        System.out.println(iStats.getMax());

    }

}
