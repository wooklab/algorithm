package com.wooklab.algorithm.study.search;

import java.util.Scanner;

public class BinarySearchWithArrays {

    public static void main(String[] args) {
        BinarySearchWithArrays m = new BinarySearchWithArrays();
        Scanner sc = new Scanner(System.in);

        System.out.print("요소수:");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("오름차순으로 수를 입력하세요");
        for (int i = 0; i < n; i++) {
            do {
                System.out.print("a[" + i + "]:");
                a[i] = sc.nextInt();
            } while (i != 0 && a[i] < a[i - 1]);
        }
        System.out.print("검색할 키 값을 입력하세요:");
        int key = sc.nextInt();

        int result = m.binSearch(n, a, key);
        if (result != -1) {
            System.out.println("키의 위치: " + result);
        } else {
            System.out.println("찾는 키가 포함되지 않았습니다.");
        }
    }

    private int binSearch(int n, int[] a, int key) {
        int pointerLeft = 0;
        int pointerRight = n - 1;

        do {
            int pointerCenter = (pointerLeft + pointerRight) / 2;
            if (a[pointerCenter] == key) {
                return pointerCenter;
            } else if (a[pointerCenter] < key) {
                pointerLeft = pointerCenter + 1;
            } else {
                pointerRight = pointerCenter - 1;
            }
        } while (pointerLeft <= pointerRight);
        return -1;
    }

}
