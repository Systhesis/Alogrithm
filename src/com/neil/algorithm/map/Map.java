package com.neil.algorithm.map;

/**
 * @author neil zhong
 * @interfacename Map
 * @description TODO
 * @date 2021/6/27 下午12:41
 **/
public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V value);
    int getSize();
    boolean isEmpty();
}
