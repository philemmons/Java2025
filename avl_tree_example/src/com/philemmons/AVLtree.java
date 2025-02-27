package com.philemmons;

class Node<T> {

    protected T data;
    protected int height = 0;

    protected Node<T> leftKid;
    protected Node<T> rightKid;

    public Node(T obj) {
        this.data = obj;
        this.leftKid = this.rightKid = null;
        height = 1;
    }

    public String toString() {
        return "value: " + data;
    }

}

class AVLtree<E> {

    private Node<E> root;

    //protected int balanceVal;

    public AVLtree() {
        root = null;
    }

    private int height(Node<E> node) {

        if (node == null) {
            return 0;
        }
        return node.height;

    }

    private void updateHeight(Node<E> node) {

        node.height = Math.max(height(node.leftKid), height(node.rightKid)) + 1;
    }

    private int getBalance(Node<E> node) {

        if (node == null) {
            return 0;
        }
        return height(node.leftKid) - height(node.rightKid);
    }

    public void add(E obj) {
        Node<E> newNode = new Node<>(obj);

        if (root == null) {

            root = newNode;
            return;
        }

        add(root, newNode);
    }

    public void add(Node<E> parent, Node<E> newNode) {

        if (((Comparable<E>) newNode.data).compareTo(parent.data) > 0) {

            if (parent.rightKid == null) {
                parent.rightKid = newNode;

                updateHeight(newNode);

            } else {
                add(parent.rightKid, newNode);
            }
        } else {
            if (parent.leftKid == null) {
                parent.leftKid = newNode;

                updateHeight(newNode);

            } else {

                add(parent.leftKid, newNode);
            }
        }
        checkBalance(newNode);
    }

    private void checkBalance(Node<E> node) {

        int balanceVal = getBalance(node);

        if ((balanceVal > 1) || (balanceVal < -1)) {
            System.out.println("rebalance");
           // reBalance(node);
        }

        //checkBalance(node.leftKid);
        

    }

    private void reBalance(Node<E> node) {

        int balanceVal = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases
        // leftKid Rotate
        if (balanceVal > 1 && (((Comparable<E>) node.data).compareTo(node.leftKid.data) < 0)) {

            rightRotate(node);
        }

        // rightKid Rotate
        if (balanceVal < -1 && (((Comparable<E>) node.data).compareTo(node.rightKid.data) > 0)) {

            leftRotate(node);
        }

        // leftKid rightKid Rotate
        if (balanceVal > 1 && (((Comparable<E>) node.data).compareTo(node.leftKid.data) < 0)) {

            node.leftKid = leftRotate(node.leftKid);
            rightRotate(node);
        }

        // rightKid leftKid Rotate
        if (balanceVal < -1 && (((Comparable<E>) node.data).compareTo(node.rightKid.data) > 0)) {

            node.rightKid = rightRotate(node.rightKid);
            leftRotate(node);
        }
    }

    private Node<E> rightRotate(Node<E> node) {
        Node<E> n1 = node.leftKid;
        Node<E> n2 = n1.rightKid;

        // Perform rotation
        n1.rightKid = node;
        node.leftKid = n2;

        // Update heights
        node.height = Math.max(height(node.leftKid), height(node.rightKid)) + 1;
        n1.height = Math.max(height(n1.leftKid), height(n1.rightKid)) + 1;

        // Return new root
        return n1;

    }

    private Node<E> leftRotate(Node<E> node) {
        Node<E> n1 = node.rightKid;
        Node<E> n2 = n1.leftKid;

        // Perform rotation
        n1.leftKid = node;
        node.rightKid = n2;

        // Update heights
        node.height = Math.max(height(node.leftKid), height(node.rightKid)) + 1;
        n1.height = Math.max(height(n1.leftKid), height(n1.rightKid)) + 1;

        // Return new root
        return n1;
    }

    //PreOrder Traversal - root, leftKid kids, rightKid kids
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
       

  /* 
  theTree.add(10);
  theTree.add(20);
  theTree.add(30);
  theTree.add(40);
  theTree.add(50);
  theTree.add(25);
*/
        theTree.inOrder(theTree.root);

    }
}
