package com.neil.alogrithm;

import java.util.Random;

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

    /**
     * description 生成随机数组
     *
     * @name generatorRandomArray
     * @author nan2.zhong
     * @date 2021/5/30 下午7:07
     * @param n
     * @param bound
     * @return java.lang.Integer[]
     */
    public static Integer[] generatorRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
