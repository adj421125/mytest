package com.example.demo.util;

public class MyTest {
    /**
     * 冒泡排序
     */
    public static int[] sortByLargeToSmall(int[] arr) {
        for (int j = arr.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int a = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = a;
                }
            }
        }
        return arr;
    }
}