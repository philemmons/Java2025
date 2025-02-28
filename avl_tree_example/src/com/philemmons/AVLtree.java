package com.philemmons;

class AVLTree<T extends Comparable<T>> {

    class Node<T> {

        T data;
        int height;

        Node<T> leftKid = null;
        Node<T> rightKid = null;

        Node(T obj) {
            this.data = obj;
            this.height = 1;
        }
    }

    private Node<T> root;

    private int height(Node<T> node) {

        return (node == null) ? 0 : node.height;
    }

    private int max(int a, int b) {

        return Math.max(a, b);
    }

    private Node<T> rightRotate(Node<T> rootNode) {

        Node<T> leftNode = rootNode.leftKid;
        Node<T> centerNode = leftNode.rightKid;

        leftNode.rightKid = rootNode;
        rootNode.leftKid = centerNode;

        rootNode.height = max(height(rootNode.leftKid), height(rootNode.rightKid)) + 1;
        leftNode.height = max(height(leftNode.leftKid), height(leftNode.rightKid)) + 1;

        return leftNode;
    }

    private Node<T> leftRotate(Node<T> rootNode) {

        Node<T> rightNode = rootNode.rightKid;
        Node<T> centerNode = rightNode.leftKid;

        rightNode.leftKid = rootNode;
        rootNode.rightKid = centerNode;

        rootNode.height = max(height(rootNode.leftKid), height(rootNode.rightKid)) + 1;
        rightNode.height = max(height(rightNode.leftKid), height(rightNode.rightKid)) + 1;

        return rightNode;
    }

    private int getBalance(Node<T> currentNode) {

        return (currentNode == null) ? 0 : height(currentNode.leftKid) - height(currentNode.rightKid);
    }

    public void insert(T data) {

        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> parent, T data) {

        if (parent == null) {
            return new Node<>(data);
        }

        if (data.compareTo(parent.data) < 0) {

            parent.leftKid = insertRec(parent.leftKid, data);

        } else if (data.compareTo(parent.data) > 0) {

            parent.rightKid = insertRec(parent.rightKid, data);

        } else {

            return parent;
        }

        parent.height = 1 + max(height(parent.leftKid), height(parent.rightKid));
        int balance = getBalance(parent);

        if (balance > 1 && data.compareTo(parent.leftKid.data) < 0) {
            System.out.println("Right Rotation - "  + parent.data);
            return rightRotate(parent);
        }

        if (balance < -1 && data.compareTo(parent.rightKid.data) > 0) {
            System.out.println("Left Rotation - "  + parent.data);
            return leftRotate(parent);
        }

        if (balance > 1 && data.compareTo(parent.leftKid.data) > 0) {
            System.out.println("Left-Right Rotation - " + parent.data);
            parent.leftKid = leftRotate(parent.leftKid);

            return rightRotate(parent);
        }

        if (balance < -1 && data.compareTo(parent.rightKid.data) < 0) {
            System.out.println("Right-Left Rotation - " + parent.data);
            parent.rightKid = rightRotate(parent.rightKid);

            return leftRotate(parent);
        }

        return parent;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> parent) {

        if (parent != null) {

            inOrder(parent.leftKid);
            System.out.print(parent.data + " ");
            inOrder(parent.rightKid);
        }
    }

    public static void main(String[] args) {

        AVLTree<Integer> theTree = new AVLTree<>();

        theTree.insert(43);
        theTree.insert(18);
        theTree.insert(22);
        theTree.insert(9);
        theTree.insert(21);
        theTree.insert(6);
        theTree.insert(8);
        theTree.insert(20);
        theTree.insert(63);
        theTree.insert(50);
        theTree.insert(62);
        theTree.insert(51);

        System.out.println("Inorder traversal:");

        theTree.inOrder();
    }
}
