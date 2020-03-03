package com.src.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class TopNBuzzwords {

	private static List<String> topNBuzzwords(int numToys, int topToys, List<String> toys, int numQuotes, List<String> quotes) {
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		Comparator<Map.Entry<String, List<Integer>>> comparator = new Comparator<Map.Entry<String,List<Integer>>>() {

			@Override
			public int compare(Entry<String, List<Integer>> m1, Entry<String, List<Integer>> m2) {
				List<Integer> l1 = m1.getValue();
				List<Integer> l2 = m2.getValue();
				
				if(!l1.equals(l2))
					return l2.get(0).compareTo(l1.get(0));
				
				return l2.get(1).compareTo(l2.get(1));
			}
			
		};
		PriorityQueue<Map.Entry<String, List<Integer>>> pq = new PriorityQueue<Map.Entry<String,List<Integer>>>(comparator);
		
		for(int i = 0; i < quotes.size(); i++) {
			String[] quote = quotes.get(i).split(" ");
			//boolean thisQuote = true;
			Set<String> set = new HashSet<String>();
			
			for(int j = 0; j < quote.length; j++) {
				String word = quote[j].replaceAll("[!\\.,]", "");
				if(toys.contains(word.toLowerCase())) {
					List<Integer> val = map.get(word);//freq and num_quotes_where_word_occurs
					if(val == null) { //if word seen first time or not exists in map yet
						val = new LinkedList<Integer>();
						val.add(0,1);
						val.add(1,1);
						//thisQuote = false;
						set.add(word);
					} else {
						Integer freq = val.get(0);
						Integer count = val.get(1);
						val.remove(0);
						val.add(0,freq+1);
						if(!set.contains(word)) {//increment count only once per quote;
							val.remove(1);
							val.add(1,count+1);
							//thisQuote = false;
							set.add(word);
						}
					}
					map.put(word,val);
				}
			}
		}
		for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			pq.add(entry);
		}
		
		List<String> result = new ArrayList<String>();
		
		for(int i = 0; i < pq.size(); i++) {
			while(!pq.isEmpty() && result.size() < topToys) {
				result.add(pq.poll().getKey());
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int numToys = 6; 
		int topToys = 2; 
		List<String> toys = Arrays.asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft"); 
		int numQuotes = 6; 
		List<String> quotes = Arrays.asList(
		/*
		 * "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
		 * "The new Elmo dolls are super high quality",
		 * "Expect the Elsa dolls to be very popular this year, Elsa!",
		 * "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
		 * "For parents of older kids, look into buying them a drone",
		 * "Warcraft is slowly rising in popularity ahead of the holiday season"
		 */
				"Elmo Elmo",
				"Elmo",
				"Elsa Elsa!",
				"Elsa Elmo Elsa",
				"drone",
				"Warcraft"
				);
		
		List<String> result = topNBuzzwords(numToys, topToys, toys, numQuotes, quotes);
		System.out.println(result.toString());
	}
}
