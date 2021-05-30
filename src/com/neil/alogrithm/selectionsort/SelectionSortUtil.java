package com.neil.alogrithm.selectionsort;

import com.neil.alogrithm.ArrayGenerator;
import com.neil.alogrithm.SortingHelper;
import com.neil.alogrithm.entity.Student;
import com.neil.alogrithm.linearsearch.LinearSearchUtil;

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

//        long startTime = System.nanoTime();
//        SelectionSortUtil.sort(arr);
//        long endTime = System.nanoTime();
//
//        double time = (endTime - startTime) / 1000000000.0;
//
//        if(!SortingHelper.isSorted(arr)) {
//            throw new RuntimeException("Selection sort failed!!!");
//        }
//
//        System.out.println(time + "s");

        SortingHelper.sortTest("com.neil.alogrithm.selectionsort.SelectionSortUtil", arr);

    }


}
