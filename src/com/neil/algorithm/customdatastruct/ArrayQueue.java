package com.neil.algorithm.customdatastruct;

/**
 * @author neil zhong
 * @classname ArrayQueue
 * @description TODO
 * @date 2021/6/5 下午3:09
 **/
public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayQueue() {
        this.array = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0; i < array.getSize(); i ++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1) {
                res.append(" , ");
            }
        }
        res.append("] tail");

        return res.toString();
    }
}
