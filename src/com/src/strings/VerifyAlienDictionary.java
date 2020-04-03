package com.src.strings;

import java.util.Map;
import java.util.HashMap;

public class VerifyAlienDictionary {
	static Map<Character,Integer> map;
    
    //Create Char,Index map using the order dictionary
    private static void init(String order) {
        map = new HashMap<Character,Integer>();
        
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
    }
    
    //Check if char for curr word is ordered compared to char for next word
    //If equal -- the loop should continue to check for next chars for both words
    //If return 0 -- these words are ordered, move the outer loop ahead
    //If return -1 -- false;
    private static int isOrdered(Character a, Character b) {
        if (map.get(a) < map.get(b))
            return 0;
        else if (map.get(a) == map.get(b))
            return 1;
        else return -1;
    }
    
    public static boolean isAlienSorted(String[] words, String order) {
        init(order);
        
        if (words.length <= 1) return true;
        
        for(int i = 0; i < words.length - 1; i++) {
            
            for(int j = 0; j < words[i].length(); j++) {
                
                //when next word is smaller than curr word and they were equal upto the point
                //example, ["apple", "app"], "abcdefghijklmnopqrstuvwxyz"
                if (j >= words[i+1].length())
                    return false;
                
                if(isOrdered(words[i].charAt(j),words[i+1].charAt(j)) == 0)
                    break;
                else if(isOrdered(words[i].charAt(j),words[i+1].charAt(j)) == 1)
                    continue;
                else if(isOrdered(words[i].charAt(j),words[i+1].charAt(j)) == -1)
                    return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	String[] words = {"hello","leetcode"};
    	String order = "hlabcdefgijkmnopqrstuvwxyz";
    	
    	System.out.println(isAlienSorted(words,order));
    }
}
