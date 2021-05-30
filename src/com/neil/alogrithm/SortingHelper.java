package com.neil.alogrithm;

import com.neil.alogrithm.selectionsort.SelectionSortUtil;

import java.lang.reflect.Method;

/**
 * @author neil zhong
 * @classname SortingHelper
 * @description TODO
 * @date 2021/5/30 下午7:10
 **/
public class SortingHelper {
    private SortingHelper() {}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        try {
            Class clazz = Class.forName(sortName);
//            Object obj = clazz.newInstance();
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if("sort".equals(method)) {
                    method.invoke(null, (Object) arr);
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if(!SortingHelper.isSorted(arr)) {
            throw new RuntimeException("Selection sort failed!!!");
        }

        System.out.println(time + "s");
    }
}
