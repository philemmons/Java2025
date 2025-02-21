package com.philemmons;

public class BST {

    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;

        } else {

            Node focusNode = root;

            Node parent;

            while (true) {
                parent = focusNode;

                if (key < focusNode.key) {

                    focusNode = focusNode.leftKid;

                    if (focusNode == null) {
                        parent.leftKid = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightKid;

                    if (focusNode == null) {
                        parent.rightKid = newNode;
                        return;
                    }
                }
            }

        }
    }

    //InOrder Traversal - ascending order
    public void inOrder(Node focusNode) {

        if (focusNode != null) {

            inOrder(focusNode.leftKid);

            System.out.println(focusNode);

            inOrder(focusNode.rightKid);

        }
    }

    //PreOrder Traversal - root, all left kids, root, all right kids
    public void preOrder(Node focusNode) {

        if (focusNode != null) {

            System.out.println(focusNode);

            preOrder(focusNode.leftKid);

            preOrder(focusNode.rightKid);
        }
    }

    //PreOrder Traversal - all left kids, root, all right kids, root
    public void postOrder(Node focusNode) {

        if (focusNode != null) {

            postOrder(focusNode.leftKid);

            postOrder(focusNode.rightKid);

            System.out.println(focusNode);
        }
    }

    public Node findNode(int key) {

        Node focusNode = root;

        while (focusNode.key != key) {

            if (key < focusNode.key) {
                focusNode = focusNode.leftKid;
                
            } else {
                focusNode = focusNode.rightKid;
            }

            if (focusNode == null) {
                return null;
            }
        }
                return focusNode;
    }

    public static void main(String[] args) {

        BST theTree = new BST();

        theTree.addNode(50, "Boss");
        theTree.addNode(25, "VP");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales manager");
        theTree.addNode(85, "Salesman");

        theTree.inOrder(theTree.root);
        System.out.println("\n");

        theTree.preOrder(theTree.root);
        System.out.println("\n");

        theTree.postOrder(theTree.root);
        System.out.println("\n");

        System.out.println(theTree.findNode(30));
    }

}

class Node {

    int key;
    String name;

    Node leftKid;
    Node rightKid;

    Node(int key, String name) {
        this.key = key;
        this.name = name;

    }

    public String toString() {
        return name + " has a key " + key;
    }

}
