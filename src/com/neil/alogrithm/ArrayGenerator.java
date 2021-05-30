package com.neil.alogrithm;

/**
 * @author nan2.zhong
 * @classname ArrayGenerator
 * @description TODO
 * @date 2021/5/30 下午5:29
 **/
public class ArrayGenerator {
    private ArrayGenerator() {}

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
