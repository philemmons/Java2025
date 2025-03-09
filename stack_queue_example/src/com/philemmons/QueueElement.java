package com.philemmons;

public class QueueElement<T> {

    T value;
    QueueElement<T> next;

    public QueueElement(T value, QueueElement<T> next) {
        this.value = value;
        this.next = next;
      
    }

    public QueueElement<T> getNext() {
        return next;
    }

    public T getVal(){
        return value;
    }
}