package com.neil.algorithm.customdatastruct;

/**
 * @author neil zhong
 * @interfacename Stack
 * @description TODO
 * @date 2021/6/5 上午11:04
 **/
public interface Stack<E> {
    E pop();
    E peek();
    void push(E e);
    boolean isEmpty();
    int getSize();

}
