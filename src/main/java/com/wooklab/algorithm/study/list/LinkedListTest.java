package com.wooklab.algorithm.study.list;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("A");
        printStatus(list);

        list.addFirst("B");
        printStatus(list);

        list.addLast("C");
        printStatus(list);

        list.search("B", String::compareTo);
        printStatus(list);

        System.out.println(list.hasOneNode());
        System.out.println(list.hasTowNode());
        list.search("C", String::compareTo);
        System.out.println(list.isTail());

        list.removeLast();
        printStatus(list);
        System.out.println(list.hasTowNode());

        list.removeFirst();
        printStatus(list);
        System.out.println(list.hasOneNode());
        System.out.println(list.isEmpty());
    }

    private static void printStatus(LinkedList<String> list) {
        System.out.println("===============");
        System.out.print("current: ");
        list.printCurrentNode();
        list.dump();
    }
}
