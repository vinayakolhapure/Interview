package com.src.practice;

import java.util.Map;
import java.util.HashMap;

class LRUCache {
    
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        
        Node(int k, int v) {
            key = k;
            val = v;
            next = null;
            prev = null;
        }
    }
    
    Node head;
    Node tail;
    int capacity;
    int size;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
    	
    	/*
    	 * Initialize a dummyHead and a dummyTail for reference.
    	 *  head	tail
    	 * |0|0|--> |0|0|
    	 * | | |<-- | | |
    	 * 
    	 * addHead(key, value): new node sits between head and head's next (tail for first entry)
    	 *  1. get Head's next and place new node between head and head's next
    	 *  2. Don't forget to increment size, add node to map
    	 *  3. Check for capacity - if size > capacity --> get tail.prev and remove it
    	 * 
    	 * remove(key)
    	 *  1. get the node to be removed from map -- map.get(key)
    	 *  2. get node's prev and next
    	 *  3. link prev and next around the node to remove node.
    	 *  4. Don't forget to decrement size.
    	 * */
    	
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        
        map = new HashMap<Integer,Node>();
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(key);
            addHead(key, node.val);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(key);
            addHead(key,value);
        } else {
            addHead(key, value);
        }
    }
    
    private void remove(int key) {
        Node node = map.get(key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
        map.remove(key);
    }
    
    private void addHead(int key, int value) {
        Node newNode = new Node(key, value);
        Node headNext = head.next;
        head.next = newNode;
        newNode.next = headNext;
        headNext.prev = newNode;
        newNode.prev = head;
        size++;
        map.put(key,newNode);
        
        if(size > capacity) {
            Node preTail = tail.prev;
            remove(preTail.key);
        }
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache( 2 /* capacity */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.get(1);       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	cache.get(2);       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	cache.get(1);       // returns -1 (not found)
    	cache.get(3);       // returns 3
    	cache.get(4);       // returns 4
    }
}