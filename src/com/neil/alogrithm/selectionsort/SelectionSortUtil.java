package com.neil.alogrithm.selectionsort;

/**
 * @author neil zhong
 * @classname SelectionSortUtil
 * @description TODO
 * @date 2021/5/30 下午6:13
 **/
public class SelectionSortUtil<E> {

    private SelectionSortUtil() {}

    public static void sort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 选择arr[i, ... n) 中的最小值索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 5, 3, 6};

        sort(arr);
        printlnArr(arr);


    }

    private static<E> void printlnArr(E[] arr) {
        for(E obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
