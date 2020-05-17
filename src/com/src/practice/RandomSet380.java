package com.src.practice;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class RandomSet380 {
    
    Map<Integer,Integer> map;
    List<Integer> list;
    Random random = new Random();;

    /** Initialize your data structure here. */
    public RandomSet380() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        /*
            1. check if key exists in map
            2. put in map at list.size() // if list is (10), next element will be at index 1
            3. add in list at list.size();
        */
        if(map.containsKey(val))
            return false;
        
        map.put(val, list.size());
        list.add(list.size(),val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        /*
        check if val exists in map
        get index of val, get last element FROM LIST
        add lastElement in index --> list.set(index, lastElement)
        put lastElement in index --> map.put(lastElement, index)
        list.remove(list.size()-1)
        map.remove(val)
        */
        if(!map.containsKey(val))
            return false;
        
        int index = map.get(val);
        int lastElement = list.get(list.size()-1);
        
        list.set(index,lastElement);
        map.put(lastElement,index);
        
        list.remove(list.size()-1);
        map.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
    
    public static void main(String[] args) {
    	RandomSet380 set = new RandomSet380();
    	//["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
    	//[[],[1],[2],[2],[],[1],[2],[]]
    	set.insert(1);
    	set.insert(2);
    	System.out.println(set.getRandom());
    	
    	set.remove(1);
    	System.out.println(set.getRandom());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
