package com.neil.algorithm.selectionsort;

import com.neil.algorithm.ArrayGenerator;
import com.neil.algorithm.SortingHelper;

/**
 * @author neil zhong
 * @classname SelectionSortUtil
 * @description TODO
 * @date 2021/5/30 下午6:13
 **/
public class SelectionSortUtil {

    private SelectionSortUtil() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 选择arr[i, ... n) 中的最小值索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                // < 0 前者小于后者
                if(arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        Integer[] arr = {1, 4, 2, 5, 3, 6};
//
//        sort(arr);
//        printlnArr(arr);
//        Student[] students = {
//                new Student("Alice", 98),
//                new Student("Bobo", 100),
//                new Student("Charles", 66),
//        };
//
//        SelectionSortUtil.sort(students);
//        SelectionSortUtil.printlnArr(students);

        int n = 100000;
        Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);

        SortingHelper.sortTest("com.neil.alogrithm.selectionsort.SelectionSortUtil", arr);

    }


}
