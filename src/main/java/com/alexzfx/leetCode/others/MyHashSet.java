package com.alexzfx.leetCode.others;

/**
 * Author : Alex
 * Date : 2018/9/19 14:26
 * Description : 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */
public class MyHashSet {
    int[] hash = new int[10000];

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        for (int i = 0; i < hash.length; i++) {
            hash[i] = -1;
        }
    }

    public void add(int key) {
        int off = key % 10000;
        while (hash[off] != -1 && hash[off] != key) {
            ++off;
            if (off >= 10000) {
                off = 0;
            }
            if (off == key % 10000) {
                return;
            }
        }
        hash[off] = key;
    }

    public void remove(int key) {
        int off = key % 10000;
        while (hash[off] != key) {
            ++off;
            if (off >= 10000) {
                off = 0;
            }
            if (off == key % 10000) {
                return;
            }
        }
        hash[off] = -1;
    }

    /**
     * Returns true if this set did not already contain the specified element
     */
    public boolean contains(int key) {
        int off = key % 10000;
        while (hash[off] != key) {
            ++off;
            if (off >= 10000) {
                off = 0;
            }
            if (off == key % 10000) {
                return false;
            }
        }
        return true;
    }
}
