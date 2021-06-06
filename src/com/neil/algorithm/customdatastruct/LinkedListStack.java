package com.neil.algorithm.customdatastruct;

/**
 * @author neil zhong
 * @classname LinkedListStack
 * @description TODO
 * @date 2021/6/5 下午7:35
 **/
public class LinkedListStack<E> implements Stack<E> {

    LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }
}
