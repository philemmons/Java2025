package com.philemmons;

import java.util.ArrayList;
import java.util.Arrays;

public class JavaTutGenerics {

    public static void main(String[] args) {
        String[] gA1 = {"one", "two"};
        Integer[] gA2 = {1, 2, 3, 4};
        printStuff(gA1);
        printStuff(gA2);

        ArrayList<Integer> aL1 = new ArrayList<>(Arrays.asList(1,2,3,4));

        printAL(aL1);

        MyGeneric<Integer> myGI = new MyGeneric<Integer>();
        myGI.setVal(10);
        System.out.println(myGI.getVal());

        MyGeneric<String> myGS = new MyGeneric<String>();
        myGS.setVal("Chandra");
        System.out.println(myGS.getVal());

    }

    public static <E> void printStuff(E[] arr) {
        for (E x : arr) {
            System.out.println(x);
        }
    }

    public static void printAL(ArrayList<?> aL) {
        for (Object x : aL) {
            System.out.println(x);
        }
    }

}

class MyGeneric<T> {

    T val;

    public void setVal(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }
}
