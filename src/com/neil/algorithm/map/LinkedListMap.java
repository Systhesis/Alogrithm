package com.neil.algorithm.map;

/**
 * @author neil zhong
 * @classname LinkedListMap
 * @description TODO
 * @date 2021/6/27 下午12:42
 **/
public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyHead;
    private int size;


    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        }else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if(prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            return delNode.value;
        }

        return null;

    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(key) == null ? null : getNode(key).value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if(cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
