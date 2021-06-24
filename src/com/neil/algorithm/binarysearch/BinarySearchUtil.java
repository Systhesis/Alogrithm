package com.neil.algorithm.binarysearch;

/**
 * @author neil zhong
 * @classname BinarySearchUtil
 * @description TODO
 * @date 2021/6/24 下午9:01
 **/
public class BinarySearchUtil {
    private BinarySearchUtil(){}

    public static <E extends Comparable<E>> int search(E[] arr, E target) {
        int l = 0, r = arr.length - 1;


        while(l <= r) {
            int mid = (l + r) / 2;
            if(arr[mid].compareTo(target) == 0) {
                return mid;
            }
            if(arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return -1;

    }


    public static <E extends Comparable<E>> int searchR(E[] arr, E target) {
        return searchR(arr, 0, arr.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        if(l > r) {
            return -1;
        }
        int mid = (l + r) / 2;

        if(data[mid].compareTo(target) == 0) {
            return mid;
        }

        return data[mid].compareTo(target) < 0 ?
                searchR(data, mid + 1, r, target) :  searchR(data, l, mid - 1, target);
    }

    //> target的最小值索引
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0, r = data.length;

        //在data[l, r]中寻找解
        while(l < r) {
            int mid = (l + r) / 2;
            if(data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid; //因为mid可能是解
            }
        }
        return l; // return r;
    }

    //> target 返回最小值索引
    // == target 返回最大索引

    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int u = upper(data, target);
        if(u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }
}
