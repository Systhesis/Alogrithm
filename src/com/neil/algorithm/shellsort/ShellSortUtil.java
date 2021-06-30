package com.neil.algorithm.shellsort;

/**
 *
 */
public class ShellSortUtil {
    private ShellSortUtil() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        int h = data.length / 2;

        while(h >= 1) {
            //分成了h份， 每一份的开头是start
            for(int start = 0; start < h; start ++) {
                //对data[start, start+h, start+2h, start+3h...]进行插入排序 下面是插入排序
                for(int i = start + h; i < data.length; i += h) {
                    E t = data[i];
                    int j;
                    //比t大的往后移动 最终找到正确的j的位置
                    for(j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = t;
                }
            }

            h /= 2;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        int h = data.length / 2;

        while(h >= 1) {
//            //分成了h份， 每一份的开头是start
//            for(int start = 0; start < h; start ++) {
                //对data[start, start+h, start+2h, start+3h...]进行插入排序 下面是插入排序
                for(int i = h; i < data.length; i ++) {
                    E t = data[i];
                    int j;
                    //比t大的往后移动 最终找到正确的j的位置
                    for(j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = t;
                }
//            }

            h /= 2;
        }
    }


}
