package com.neil.algorithm.set;

/**
 * @author neil zhong
 * @interfacename Set
 * @description TODO
 * @date 2021/6/27 上午11:55
 **/
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
