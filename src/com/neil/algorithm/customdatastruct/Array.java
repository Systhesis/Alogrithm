package com.neil.algorithm.customdatastruct;

/**
 * @author neil zhong
 * @classname Array
 * @description TODO
 * @date 2021/6/5 上午8:42
 **/
public class Array<E> {
    private E[] data;
    private int size;


    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("get failed, index < 0 || index > size");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("get failed, index < 0 || index > size");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed, index < 0 || index > size");
        }
        E ret = data[index];
        for(int i = index + 1; i < size; i ++) {
            data[ i - 1] = data[i];
        }
        size --;
        data[size] = null;
        if(size == data.length / 2) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(int e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    public void add(int index, E e) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("addLast failed, index < 0 || index > size");
        }

        if( size == data.length) {
            resize(2 * data.length);
            //throw new IllegalArgumentException("addLast failed, Array is full");
        }
        for(int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void swap(int i, int j) {
        if(i < 0 || i >= size || j < 0 || j >= size ) {
            throw new IllegalArgumentException("index is illegal");
        }

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d \n", size, data.length));
        res.append("[");
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(" , ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
