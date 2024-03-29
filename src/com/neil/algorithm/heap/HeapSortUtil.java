package com.neil.algorithm.heap;

/**
 * @author neil zhong
 * @classname HeapSortUtil
 * @description TODO
 * @date 2021/6/27 下午3:40
 **/
public class HeapSortUtil {
    private HeapSortUtil() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for(E e : data) {
            maxHeap.add(e);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        if(data.length <= 1) {
            return;
        }
        for (int i = (data.length - 1 - 1 ) / 2; i >= 0; i --) {
            siftDown(data, i, data.length);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            swap(data, 0, i);
            siftDown(data, 0, i);
        }
    }

    //对data[0, n)所形成的最大堆中，索引k的元素，执行siftDown
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while(2 * k + 1 < n) {
            int j = 2 * k + 1;
            if(j + 1 < n &&
                    data[j + 1].compareTo(data[j]) > 0){
                j = 2 * k + 2;
            }
            //此时data[j]是leftChild和rightChild中的最大值
            if(data[k].compareTo(data[j]) >= 0) {
                break;
            } else {
                swap(data, k, j);
                k = j;
            }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
