package com.neil.algorithm.insertionsort;


import com.neil.algorithm.ArrayGenerator;
import com.neil.algorithm.SortingHelper;

/**
 * @author zhongnan1
 */
public class InsertionSortUtil {
    private InsertionSortUtil() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {
            // 将arr[i]插入到合适的位置
//            for(int j = i; j - 1 >= 0; j--) {
//                if(arr[j].compareTo(arr[j-1]) < 0) {
//                    swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
//            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
//                swap(arr, j, j - 1);
//            }
            for (int j = i; j - 1)
        }

    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int n = 10000;
        Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);

        SortingHelper.sortTest("com.neil.algorithm.insertionsort.InsertionSortUtil", arr);

    }

}
