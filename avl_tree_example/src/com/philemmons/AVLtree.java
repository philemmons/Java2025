package com.philemmons;

class Node<T> {

    protected T data;

    protected Node<T> leftKid;
    protected Node<T> rightKid;

    protected Node<T> parent;

    //protected int height = 0;
    public Node(T obj) {
        this.data = obj;
        this.parent = this.leftKid = this.rightKid = null;
    }

    public String toString() {
        return "value: " + data;
    }

}

class AVLtree<E> {

    Node<E> root;
    //private int currentSize;

    public AVLtree() {
        root = null;
        //currentSize = 0;
    }

    public void add(E obj) {
        Node<E> node = new Node<>(obj);

        if (root == null) {
            root = node;
            //currentSize++;
            return;
        }
        add(root, node);
    }

    public void add(Node<E> parent, Node<E> newNode) {

        if (((Comparable<E>) newNode.data).compareTo(parent.data) > 0) {

            if (parent.rightKid == null) {

                parent.rightKid = newNode;
                newNode.parent = parent;
                //currentSize++;

            } else {
                add(parent.rightKid, newNode);
            }
        } else {
            if (parent.leftKid == null) {

                parent.leftKid = newNode;
                newNode.parent = parent;
                //currentSize++;

            } else {
                add(parent.leftKid, newNode);
            }
        }
        checkBalance(newNode);
    }

    private void checkBalance(Node<E> node) {

        if ((height(node.leftKid) - height(node.rightKid) > 1)
                || (height(node.leftKid) - height(node.rightKid) < -1)) {
            reBalance(node);
        }

        if (node.parent == null) {
            return;
        }

        checkBalance(node.parent);
    }

    private void reBalance(Node<E> node) {

        if (height(node.leftKid) - height(node.rightKid) > 1) {
            if (height(node.leftKid.leftKid) > height(node.leftKid.rightKid)) {
                node = rightRotate(node);
            } else {
                node = leftRightRotate(node);
            }
        } else {

            if (height(node.rightKid.leftKid) > height(node.rightKid.rightKid)) {
                node = leftRotate(node);
            } else {
                node = rightLeftRotate(node);
            }
        }

        if (node.parent == null) {
            root = node;
        }

    }

    private int height(Node<E> node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.leftKid);
        int rightHeight = height(node.rightKid);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    private Node<E> rightRotate(Node<E> node) {
        Node<E> leftNode = node.leftKid;

        node.leftKid = leftNode.rightKid;
        leftNode.rightKid = node;
        
        return leftNode;

    }

    private Node<E> leftRotate(Node<E> node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leftRotate'");
    }

    private Node<E> leftRightRotate(Node<E> node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leftRightRotate'");
    }

    private Node<E> rightLeftRotate(Node<E> node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rightLeftRotate'");
    }

    //PreOrder Traversal - root, left kids, right kids
    public void inOrder(Node<E> focusNode) {

        if (focusNode != null) {

            inOrder(focusNode.leftKid);

            System.out.println(focusNode.toString());

            inOrder(focusNode.rightKid);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello AVL Tree!\n");

        AVLtree<Integer> theTree = new AVLtree<>();
        /* 
        theTree.add(43);
        theTree.add(18);
        theTree.add(22);
        theTree.add(9);
        theTree.add(21);
        theTree.add(6);
        theTree.add(8);
        theTree.add(20);
        theTree.add(63);
        theTree.add(50);
        theTree.add(62);
        theTree.add(51);
         */
        theTree.add(10);
        theTree.add(8);
        theTree.add(12);
        theTree.add(4);

        theTree.inOrder(theTree.root);

    }
}
