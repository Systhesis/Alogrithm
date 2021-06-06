package com.neil.algorithm.customdatastruct;

/**
 * @author neil zhong
 * @interfacename Queue
 * @description TODO
 * @date 2021/6/5 下午3:07
 **/
public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();

}
