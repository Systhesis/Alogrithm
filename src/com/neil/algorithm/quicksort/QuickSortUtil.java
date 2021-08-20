package com.neil.algorithm.quicksort;

import com.neil.algorithm.ArrayGenerator;
import com.neil.algorithm.SortingHelper;

/**
 * @author neil zhong
 * @classname QucikSortUtil
 * @description TODO
 * @date 2021/6/19 下午5:04
 **/
public class QuickSortUtil {
    private QuickSortUtil() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[]arr, int l, int r) {
        if(l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        //arr[l+1, j] < v ; arr[j+1, i] > v;
        int j = l;
        for(int i = l + 1; i <= r; i++) {
            if(arr[i].compareTo(arr[l]) < 0) {
                j ++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        sort2ways(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort2ways(E[]arr, int l, int r) {
        if(l >= r) {
            return;
        }

        int p = partition2ways(arr, l, r);
        sort2ways(arr, l, p - 1);
        sort2ways(arr, p + 1, r);
    }

    public static <E extends Comparable<E>> int partition2ways(E[] arr, int l, int r) {
        //arr[l+1, j] < v ; arr[j+1, i] > v;

        int i = l + 1, j = r;
        while(true) {
            while( i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }

            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }

            if(i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort3ways(E[] arr) {
        sort3ways(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort3ways(E[]arr, int l, int r) {
        if(l >= r) {
            return;
        }

        //arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v

        int lt = l, i = l + 1, gt = r + 1;
        while(i < gt) {
            if(arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if(arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);


            } else {
                //arr[i] == arr[l]
                i++;
            }

        }

        swap(arr, lt, l);
        //arr[l, lt - 1] < v, arr[lt, gt - 1] == v, arr[gt, r] > v
        sort3ways(arr, l, lt - 1);
        sort3ways(arr, gt, r);


    }



    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);

        SortingHelper.sortTest("com.neil.algorithm.quicksort.QuickSortUtil", arr);
    }
}
