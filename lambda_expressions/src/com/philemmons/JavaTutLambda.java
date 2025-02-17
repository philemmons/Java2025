package com.philemmons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaTutLambda {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> one2five = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        one2five.forEach(x -> System.out.println(x * 2));

        one2five.forEach(x -> {
            if (x % 2 == 0) {
                System.out.println(x);
            }
        });

        System.out.println("\nFibonacci Numbers");

        List<Integer> fib;

        fib = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(n -> n[0])
                .collect(Collectors.toList());

        fib.forEach(x -> System.out.println(x));

    }
}
