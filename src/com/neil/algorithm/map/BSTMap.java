package com.neil.algorithm.map;

import com.neil.algorithm.tree.binarysearchtree.BST;

import java.security.Key;

/**
 * @author neil zhong
 * @classname BSTMap
 * @description TODO
 * @date 2021/6/27 下午12:56
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V>  {

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if(node == null) {
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if(key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    private Node getNode(Node node, K key) {
        if(node == null) {
            return null;
        }

        if(key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if(key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if(node == null) {
            return null;
        }

        if(key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if(key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }

    }

    private Node minimum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //返回删除之后二叉树的根
    private Node removeMin(Node node) {
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);

        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(root, key) == null ? null : getNode(root ,key).value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root ,key);
        if(node == null) {
            throw new IllegalArgumentException("null");
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



    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        public Node() {
            this(null, null, null, null);
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
