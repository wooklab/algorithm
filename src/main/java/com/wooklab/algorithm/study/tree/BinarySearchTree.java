package com.wooklab.algorithm.study.tree;

import java.util.Comparator;

public class BinarySearchTree<K extends Comparable<K>, V> {

    static class Node<K, V> {

        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Node(K key, V value) {
            this(key, value, null, null);
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void print() {
            System.out.println(value);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    private int compare(K key1, K key2) {
        return (comparator == null) ? key1.compareTo(key2)
                                    : comparator.compare(key1, key2);
    }

    public V search(K key) {
        Node<K, V> pointer = root;

        while (true) {
            if (pointer == null) {
                return null;
            }

            int condition = compare(key, pointer.getKey());
            if (condition == 0) {
                return pointer.getValue();
            } else if (condition < 0) {
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
        }
    }

    private void addNode(Node<K, V> node, K key, V value) {
        int condition = compare(key, node.getKey());

        if (condition == 0) {
            System.out.println("Same data already exist");
        } else if (condition < 0) {
            if (node.left == null) {
                node.left = new Node<>(key, value);
            } else {
                addNode(node.left, key, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(key, value);
            } else {
                addNode(node.right, key, value);
            }
        }
    }

    public void add(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);
        } else {
            addNode(root, key, value);
        }
    }

    public boolean remove(K key) {
        Node<K, V> pointer = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while (true) {
            if (pointer == null) {
                return false;
            }

            int condition = compare(key, pointer.getKey());
            if (condition == 0) {
                break;
            } else {
                parent = pointer;
                if (condition < 0) {
                    isLeftChild = true;
                    pointer = pointer.left;
                } else {
                    isLeftChild = false;
                    pointer = pointer.right;
                }
            }
        }

        if (pointer.left == null) {
            if (pointer == root) {
                root = pointer.right;
            } else if (isLeftChild) {
                parent.left = pointer.right;
            } else {
                parent.right = pointer.right;
            }
        } else if (pointer.right == null) {
            if (pointer == root) {
                root = pointer.left;
            } else if (isLeftChild) {
                parent.left = pointer.left;
            } else {
                parent.right = pointer.left;
            }
        } else {
            parent = pointer;
            Node<K, V> leftSub = pointer.left; // 양쪽 노드가 존재한다면 왼쪽 노드를 기준으로 한다
            isLeftChild = true;
            while (leftSub.right != null) {
                parent = leftSub;
                leftSub = leftSub.right;    // 서브트리에서 가장 큰수를 찾아야 하기 때문에 우측 트리만 확인
                isLeftChild = false;
            }
            pointer.key = leftSub.key;
            pointer.value = leftSub.value;
            if (isLeftChild) {
                parent.left = leftSub.left;
            } else {
                parent.right = leftSub.left;
            }
        }
        return true;
    }

    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left);
            System.out.println(node.key + " " + node.value);
            printSubTree(node.right);
        }
    }

    public void print() {
        printSubTree(root);
    }
}
