package com.philemmons;

public class StackElement<T> {

    T value;
    StackElement<T> next;

    public StackElement(T value, StackElement<T> next) {
        this.value = value;
        this.next = next;
    }

    public StackElement<T> getNext() {
        return next;
    }

    public T getVal(){
        return value;
    }
}
