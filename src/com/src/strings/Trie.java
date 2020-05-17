package com.src.strings;

public class Trie {
	
	class TrieNode {
		
		private TrieNode[] links;
		private boolean isEnd;
		private final int R = 26;
		
		public TrieNode() {
			links = new TrieNode[R];
		}
		
		public boolean containsKey(char ch) {
			return links[ch - 'a'] != null;
		}
		
		public TrieNode get(char ch) {
			return links[ch - 'a'];
		}
		
		public void put(char ch, TrieNode node) {
			links[ch - 'a'] = node;
		}
		
		public void setEnd () {
			isEnd = true;
		}
		
		public boolean isEnd() {
			return isEnd;
		}
	}
	
	private TrieNode root;
	
	public Trie () {
		root = new TrieNode();
	}
	
	public void insert (String word) {
		TrieNode node = root; //to start looking
		for(int i = 0; i < word.length(); i++) {
			char currChar = word.charAt(i);
			if(!node.containsKey(currChar)) {
				node.put(currChar, new TrieNode());
			}
			node = node.get(currChar);
		}
		node.setEnd();
	}
	
	public boolean search (String word) {
		TrieNode node = searchPrefix(word);
		return node != null & node.isEnd();
	}
	
	public boolean startsWith (String word) {
		TrieNode node = searchPrefix(word);
		return node != null;
	}
	
	private TrieNode searchPrefix (String word) {
		
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char currChar = word.charAt(i);
			
			if(node.containsKey(currChar)) {
				node = node.get(currChar); //to keep traversing
			} else { 
				return null; //key doesn't exist for the curr character
			}
		}
		
		return node;
	}
	
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.insert("le");
		trie.insert("leet");
		trie.insert("code");
		
		System.out.println(trie.search("lee"));
		
		System.out.println(trie.startsWith("lee"));
	}
}
