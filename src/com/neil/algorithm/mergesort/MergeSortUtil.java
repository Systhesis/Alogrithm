package com.neil.algorithm.mergesort;

import com.neil.algorithm.ArrayGenerator;
import com.neil.algorithm.SortingHelper;

import java.util.Arrays;

/**
 * @author zhongnan1
 */
public class MergeSortUtil {
    private MergeSortUtil(){}

    //自顶向下的归并排序
    public static <E extends Comparable<E>> void sort(E[] arr) {

        sortRecursion(arr, 0, arr.length - 1);

    }

    //自底向上的归并排序
    public static <E extends Comparable<E>> void sortBu(E[] arr) {
        int n = arr.length;
        //遍历合并区间的长度
        for(int sz = 1; sz < n; sz += sz) {
            //遍历合并的两个区间的起始位置
            //合并 [i, i+sz-1] 和 [i+sz, i+sz+sz-1]
            for(int i = 0; i + sz < n  ;i += sz + sz) {
                if(arr[i+sz-1].compareTo(arr[i+sz]) > 0) {
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1, n - 1));
                }
            }
        }
    }

    public static <E extends Comparable<E>> void sortRecursion(E[] arr, int l, int r) {
        if(l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        sortRecursion(arr, l, mid);
        sortRecursion(arr, mid + 1, r);
        //两个数组已经有序
        if(arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }


    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        //temp的索引是从0开始的
        E[] temp = Arrays.copyOfRange(arr, l, r+1);

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            // arr[i] 和 arr[j]
            if(i > mid) {
                arr[k] = temp[j - l];
                j++;
            }else if(j > r) {
                arr[k] = temp[i - l];
                i++;
            }else if(temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            }else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);

        SortingHelper.sortTest("com.neil.algorithm.mergesort.MergeSortUtil", arr);
    }

}
