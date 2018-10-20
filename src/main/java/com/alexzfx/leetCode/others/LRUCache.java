package com.alexzfx.leetCode.others;

import java.util.HashMap;

/**
 * Author : Alex
 * Date : 2018/9/15 14:17
 * Description : 146. LRU缓存机制
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(10, 13);
        lruCache.put(3, 17);
        lruCache.put(6, 11);
        lruCache.put(10, 5);
        lruCache.put(9, 10);
        lruCache.get(13);
        lruCache.put(2, 19);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.put(5, 25);
        lruCache.get(8);
        lruCache.put(9, 22);
        lruCache.put(5, 5);
        lruCache.put(1, 30);
        lruCache.get(11);
        lruCache.put(9, 12);
        lruCache.get(7);
        lruCache.get(5);
        lruCache.get(8);
        lruCache.get(9);
        lruCache.put(4, 30);
        lruCache.put(9, 3);
        System.out.println(lruCache.get(9));
        System.out.println(lruCache.get(10));
        System.out.println(lruCache.get(10));

    }

    private class Node {
        int key;
        int val;
        Node next;
        Node pre;
    }

    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            moveToHead(node);
            return;
        } else if (map.size() == capacity) {
            node = removeLast();
            map.remove(node.key);
        }
        node = new Node();
        node.key = key;
        node.val = value;
        addOne(node);
        map.put(key, node);
    }

    private void addOne(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void moveToHead(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private Node removeLast() {
        Node temp = tail.pre;

        tail.pre = temp.pre;
        tail.pre.next = tail;

        temp.next = null;
        temp.pre = null;
        return temp;
    }

//    //利用linkedHashMap实现，内部实现了按使用顺序排序，删除最近未使用元素功能
//    private int capacity;
//    private LinkedHashMap<Integer, Integer> map;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                return size() > LRUCache.this.capacity;
//            }
//        };
//    }
//
//    public int get(int key) {
//        return map.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        map.put(key, value);
//    }

//    //tle
//    private int capacity;
//
//    private LinkedList<Integer> list;
//    private Map<Integer, Integer> map;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        list = new LinkedList<>();
//        map = new HashMap<>();
//    }
//
//    public int get(int key) {
//        int value = map.getOrDefault(key, -1);
//        if (value != -1) {
//            list.remove(list.indexOf(key));
//            list.addFirst(key);
//        }
//        return value;
//    }
//
//    public void put(int key, int value) {
//        int i = list.indexOf(key);
//        if (i != -1) {
//            map.remove(list.remove(i));
//        } else if (list.size() == capacity) {
//            map.remove(list.removeLast());
//        }
//        list.addFirst(key);
//        map.put(key, value);
//    }
}
