package com.philemmons;

public class Queue<T> {

    int size;

    QueueElement<T> head;
    QueueElement<T> tail;

    public Queue() {
        size = 0;
        head = null;
        tail = null;
    }

    public void enqueue(T newVal) {

        QueueElement<T> newElement = new QueueElement<>(newVal, tail);

        if (size == 0) {

            // If queue is empty, the new element is both the head and the tail
            head = newElement;
            tail = newElement;
        } else {

            // Add the new element at the end of the queue and change tail   
            tail.next = newElement;
        }
        tail = newElement;
        size++;
    }

    public T dequeue() {

        if (size == 0) {
            return null;
        }

        QueueElement<T> oldHead = head;
        head = head.getNext();
        size--;
        return oldHead.getVal();

    }

    public T peek() {

        if (size == 0) {
            return null;
        }
        return head.getVal();
    }

    public void empty() {
        size = 0;
        head = null;
        tail = null;
    }

    public static void main(String[] args) {

        Queue<String> myStringStack = new Queue<>();

        myStringStack.enqueue("Peanut Butter");
        myStringStack.enqueue("Jelly");
        myStringStack.enqueue("Vanilla");

        System.out.println(myStringStack.peek());
        System.out.println(myStringStack.dequeue());
        System.out.println(myStringStack.dequeue());
        System.out.println(myStringStack.dequeue());
        System.out.println(myStringStack.dequeue());

    }

}
