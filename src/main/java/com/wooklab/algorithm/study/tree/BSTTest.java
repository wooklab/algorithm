package com.wooklab.algorithm.study.tree;

public class BSTTest {

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        bst.add(5, "A");
        printStatus(bst);

        bst.add(3, "B");
        printStatus(bst);
        bst.add(7, "C");
        printStatus(bst);
    }

    private static void printStatus(BinarySearchTree<Integer, String> bst) {
        System.out.println("====================");
        bst.print();
    }

}
