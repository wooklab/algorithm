package com.wooklab.algorithm.study.list;

import java.util.Comparator;

public class LinkedList<E> {

    static class Node<E> {

        private final E data;

        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<E> head;
    private Node<E> current;

    public LinkedList() {
        head = current = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean hasOneNode() {
        return head != null && head.next == null;
    }

    public boolean hasTowNode() {
        return head != null && head.next != null && head.next.next == null;
    }

    public boolean isTail() {
        return current.next == null;
    }

    public E search(E obj, Comparator<? super E> comparator) {
        Node<E> pointer = head;

        while (pointer != null) {
            if (comparator.compare(obj, pointer.data) == 0) {
                current = pointer;
                return pointer.data;
            }
            pointer = pointer.next;
        }
        return null;
    }

    public void addFirst(E obj) {
        Node<E> pointer = head;
        head = current = new Node<>(obj, pointer);
    }

    public void addLast(E obj) {
        if (head == null) {
            addFirst(obj);
        } else {
            Node<E> pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = current = new Node<>(obj, null);
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = current = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                removeFirst();
            } else {
                Node<E> pointer = head;
                Node<E> prePointer = head;

                while (pointer.next != null) {
                    prePointer = pointer;
                    pointer = pointer.next;
                }
                prePointer.next = null;
                current = prePointer;
            }
        }
    }

    public void remove(Node<E> obj) {
        if (head != null) {
            if (obj == head) {
                removeFirst();
            } else {
                Node<E> pointer = head;

                while (pointer.next != obj) {
                    pointer = pointer.next;
                    if (pointer == null) {
                        return;
                    }
                }
                pointer.next = obj.next;
                current = pointer;
            }
        }
    }

    public void removeCurrentNode() {
        remove(current);
    }

    public void clear() {
        while (head != null) {
            removeFirst();
        }
        current = null;
    }

    public boolean next() {
        if (current == null || current.next == null) {
            return false;
        }
        current = current.next;
        return true;
    }

    public void printCurrentNode() {
        if (current == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println(current.data);
        }
    }

    public void dump() {
        Node<E> pointer = head;

        while (pointer != null) {
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }
}
