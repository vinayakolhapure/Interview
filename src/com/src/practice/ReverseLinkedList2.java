package com.src.practice;

public class ReverseLinkedList2 {
	
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		
		/*
		 * Reverse Linked List works as follows - Reversing the links,
		 * 1. For 1 -> 2 -> 3, use a prev (-1) reference node where prev.next = head; So, -1 -> 1 -> 2 -> 3
		 * 2. Also, use a curr as curr = head; Iterate till curr is not null
		 * 3. Hold a ref for next and make curr's next as prev, move prev to be curr, and curr to be next;
		 * 4. at the end, prev is at 3 -- Return prev.
		 * 
		 * To do something similar,
		 * 1. Hold a dummy node where dummy.next = head;
		 * 2. start with prev as dummy and curr as head;
		 * 
		 * INTUITION: move prev till prev is at m-1. Keep ref to prev in another node. 
		 * 	reverse nodes m to n and link Linked List back as follows,
		 * for 1->2->3->4->5 and m = 2, n = 4. Start with prev,node = 1, curr = 2
		 *   int the end prev = 4, curr = 5, node = 1. they are now 2<-3<-4 (final: 1->4->3->2->5)
		 *   2's (node.next) next is supposed to be 5 (curr). i.e., node.next.next = curr.
		 *   1's (node) next is supposed to 4 (prev). i.e., node.next = prev.
		 *   return dummy.next  1->4->3->2->5
		 * */
		
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        
        int i = 1;
        
        while(i<m) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        
        ListNode node = prev;
        while(i<=n) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        
        node.next.next = curr;
        node.next = prev;
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		printList(head);
		
		ListNode rev = reverseBetween(head,2,4);
		printList(rev);
	}
	
	private static void printList(ListNode head) {
		ListNode curr = head;
		while(curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println("");
	}
}
