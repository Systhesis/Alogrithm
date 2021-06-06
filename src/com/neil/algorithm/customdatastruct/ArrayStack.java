package com.neil.algorithm.customdatastruct;

/**
 * @author neil zhong
 * @classname ArrayStack
 * @description TODO
 * @date 2021/6/5 上午11:06
 **/
public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }


    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for(int i = 0; i < array.getSize(); i ++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1) {
                res.append(" , ");
            }
        }
        res.append("] top");

        return res.toString();
    }
}
