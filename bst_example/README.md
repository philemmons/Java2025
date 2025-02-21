# Binary Search Tree(BST)

- A data structure used in computer science for organizing and storing data in a sorted manner. Binary search tree follows all properties of binary tree and for every nodes, its left subtree contains values less than the node and the right subtree contains values greater than the node. This hierarchical structure allows for efficient Searching, Insertion, and Deletion operations on the data stored in the tree.

### Important Points about BST

- A Binary Search Tree is useful for maintaining sorted stream of data. It allows search, insert, delete, ceiling, max and min in O(h) time. Along with these, we can always traverse the tree items in sorted order.

- With Self Balancing BSTs, we can ensure that the height of the BST is bound be Log n. Hence we achieve, the above mentioned O(h) operations in O(Log n) time.

- When we need only search, insert and delete and do not need other operations, we prefer Hash Table over BST as a Hash Table supports these operations in O(1) time on average.

#### FAQ’s on BST:

##### 1. What is a Binary Search Tree?

- A binary search tree (BST) is a binary tree where every node in the left subtree is less than the root, and every node in the right subtree is of a value greater than the root. The properties of a binary search tree are recursive: if we consider any node as a "root," these properties will remain true.

##### 2. What is a Binary Search Tree Operation?

- There are major three operations in Binary Search Tree:

    - **a. Insertion**
    - **b. Deletion**
    - **c. Searching**
        
- Because of its properties its efficient to search any element in Binary Search Tree.

##### 3. What is Binary Search Tree and AVL tree?

- Binary Search Tree: A binary search tree (BST) is a binary tree where every node in the left subtree is less than the root, and every node in the right subtree is of a value greater than the root.

- AVL Tree: Binary search trees (BSTs) that self-balance and rotate automatically are known as AVL trees.

##### 4. What are the uses of Binary Search Tree?

- Binary search trees can be used to implement sorted stream of data and doubly ended priority queues.

##### 5. What is the difference between binary search tree and binary tree ?

- A Binary search tree is a tree that follows some order to arrange the elements, whereas the binary tree does not follow any order.


##### Source: [https://www.geeksforgeeks.org/introduction-to-binary-search-tree/](https://www.geeksforgeeks.org/introduction-to-binary-search-tree/)