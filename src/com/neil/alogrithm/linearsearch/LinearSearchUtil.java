package com.neil.alogrithm.linearsearch;

import com.neil.alogrithm.ArrayGenerator;

/**
 * @author nan2.zhong
 * @classname LinearSearchUtil
 * @description TODO
 * @date 2021/5/29 下午8:57
 **/
public class LinearSearchUtil {
    private LinearSearchUtil() {}

    public static<T> int search(T[] data, T target) {
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int n = 1000000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);

        long startTime = System.nanoTime();
        for (int k = 0; k < 100; k++) {
            LinearSearchUtil.search(data, n);
        }
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        System.out.println("n = " + n + ", 100 runs : " + time + "s");
    }
}
