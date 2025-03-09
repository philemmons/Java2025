package com.philemmons;

public class Stack<T> {

    int size;

    StackElement<T> top;

    public Stack() {
        size = 0;
        top = null;
    }

    public void push(T newVal) {

        StackElement<T> newElement = new StackElement<>(newVal, top);
        top = newElement;
        size++;
    }

    public T pop() {

        if (size == 0) {
            return null;
        }

        StackElement<T> oldTop = top;
        top = top.getNext();
        size--;
        return oldTop.getVal();

    }

    public T peek(){

        if(size == 0){
            return null;
        }
        return top.getVal();
    }

    public void empty(){
        size = 0;
        top = null;
    }

    public static void main(String[] args) {

        Stack<String> myStringStack = new Stack<>();

        myStringStack.push("Peanut Butter");
        myStringStack.push("Jelly");
        myStringStack.push("Vanilla");

        System.out.println(myStringStack.peek());
        System.out.println(myStringStack.pop());
        System.out.println(myStringStack.pop());
        System.out.println(myStringStack.pop());
        System.out.println(myStringStack.pop());

    }

}
