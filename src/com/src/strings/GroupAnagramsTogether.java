package com.src.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsTogether {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> groupedAnagrams = groupAnagrams(strs);
		
		for(List<String> list : groupedAnagrams) {
			System.out.println(list.toString());
		}
	} 
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		
		for(String word : strs) {
			int hashCode = getHashCode(word);
			if(map.containsKey(hashCode)) {
				//get List and add word to list
				List<String> list = map.get(hashCode);
				list.add(word);
				map.put(hashCode,list);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(word);
				map.put(hashCode,list);
			}
		}
		
		List<List<String>> finalList = new ArrayList<>();
		
		for(Map.Entry<Integer, List<String>> entry: map.entrySet()) {
			finalList.add(entry.getValue());
		}
		
		return finalList;
    }
	
	private static int getHashCode(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		String sortedWord = new String(charArray);
		return sortedWord.hashCode();
	}
}
