package com.neil.algorithm.set;

import com.neil.algorithm.customdatastruct.LinkedList;

/**
 * @author neil zhong
 * @classname LinkedListSet
 * @description TODO
 * @date 2021/6/27 下午12:34
 **/
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }


    @Override
    public void add(E e) {
        if(!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
