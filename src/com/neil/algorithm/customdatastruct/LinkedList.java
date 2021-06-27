package com.neil.algorithm.customdatastruct;

/**
 * @author neil zhong
 * @classname LinkedList
 * @description TODO
 * @date 2021/6/5 下午5:19
 **/
public class LinkedList<E> {

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = null;
        this.size = 0;
    }


    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0, e);
        size ++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed, index < 0 || index > size");
        }


        Node pre = dummyHead;
        for (int i = 0; i < index; i ++) {
            pre = pre.next;
        }

//            Node node = new Node(e);
//            node.next = pre.next;
//            pre.next = node;

        pre.next = new Node(e, pre.next);

    }

    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed, index < 0 || index > size");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed, index < 0 || index > size");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if(cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed, index < 0 || index > size");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node node = pre.next;
        pre.next = node.next;
        node.next = null;
        size --;

        return node.e;
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if(prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + " -> ");
            cur = cur.next;
        }
        res.append(" NULL");
        return res.toString();
    }

    private class Node {
        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }
}
