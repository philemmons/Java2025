package com.philemmons;

class Node<T> {

    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
        next = null;
    }

    @Override
    public String toString() {
        return "--" + data;
    }

    protected T getData() {
        return this.data;
    }

    protected void setData(T obj) {
        this.data = obj;
    }

    public void setNextNode(Node<T> newNode) {
        this.next = newNode;
    }

    public Node<T> getNextNode() {
        return this.next;
    }

}

public class LinkedList<T> implements List<T> {

    private Node<T> root;
    private int size;

    @Override
    public void insert(T data) {

        Node<T> node = new Node<>(data);
        node.setNextNode(root);
        root = node;
        size++;

    }

    @Override
    public void remove(T oldData) {
        if (root.getData().equals(oldData)) {
            root = root.getNextNode();

        } else {
            remove(oldData, root, root.getNextNode());
        }
        size--;
    }

    //RECURSIVE EXAMPLE
    private void remove(T data, Node<T> previousNode, Node<T> currentNode) {
        if (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                previousNode.setNextNode(currentNode.getNextNode());
                return;
            }
            remove(data, currentNode, currentNode.getNextNode());
        }
    }

    //NON RECURSIVE EXAMPLE
    @Override
    public void traverse() {

        if (isEmpty()) {
            System.out.println("List is EMPTY!");
            return;
        }

        Node<T> currentNode = root;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.getNextNode();
        }
        System.out.println("\n");
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) throws Exception {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);

        linkedList.traverse();

        linkedList.remove(30);

        linkedList.traverse();

        System.out.println(linkedList.isEmpty());

    }
}
