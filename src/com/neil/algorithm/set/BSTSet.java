package com.neil.algorithm.set;

import com.neil.algorithm.tree.binarysearchtree.BST;

/**
 * @author neil zhong
 * @classname BSTSet
 * @description TODO
 * @date 2021/6/27 下午12:01
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }


    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
