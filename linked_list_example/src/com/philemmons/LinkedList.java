package com.philemmons;


class Node<T> {

    private T data;
    private Node<T> nextNode;

    Node(T data) {
        this.data = data;
        nextNode = null;
    }

    @Override
    public String toString() {
        return "--" + data;
    }

    private T getData() {
        return this.getData();
    }

    private void setData(T obj) {
        this.data = obj;
    }

}

public class LinkedList<T> implements List<T> {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    @Override
    public void insert(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void remove(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void traverse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'traverse'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
}
