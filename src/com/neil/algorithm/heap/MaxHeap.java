package com.neil.algorithm.heap;

import com.neil.algorithm.customdatastruct.Array;

/**
 * @author neil zhong
 * @classname MaxHeap
 * @description TODO
 * @date 2021/6/27 下午3:10
 **/
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }



    private int parent(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("index-0 does not have a parent");
        }

        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            //parent还要小一点
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if(data.getSize() == 0) {
            throw new IllegalArgumentException("");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while(leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if(j + 1 < data.getSize() &&
                data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }
            //此时data[j]是leftChild和rightChild中的最大值
            if(data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            } else {
                data.swap(k, j);
                k = j;
            }
        }
    }

    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }




}
