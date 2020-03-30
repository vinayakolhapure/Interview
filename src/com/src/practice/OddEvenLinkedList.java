package com.src.practice;

public class OddEvenLinkedList {
	
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode oddEvenList(ListNode head) {
        /*
        INTUITION
        Use 4 pointers
        For Odd: Use "head" as oddHead and "odd" as odd list's tail and iterator
        For even: Use head.next as "evenHead" and "even" as even list's tail and iterator
        
        After traversing and preparing odd list and even list using the 4 pointers above - "head", "odd", "evenHead", and "even"; connect odd.next to evenHead.
        */
        
        /*
        ITERATION
        When given List is 1 -> 2 -> 3 -> 4, head and odd point to one,
        evenHead and even point to 2. 
        
        odd's next becomes even's next
        and even's next becomes odd's next. 
        
        We are basically skipping a node to go odd/even.
        */
        
        if(head == null) return null;
        
        ListNode odd = head;
        ListNode evenHead = head.next, even = evenHead;
        
        while(even != null && even.next != null) {
            //when input is 1 -> 2, even.next is null and hence we get out.
            
            //1. odd part
            odd.next = even.next; //skip even node
            odd = odd.next; // move pointer odd along
            
            //2. even part
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;
        
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		printList(head);
		
		ListNode oddEven = oddEvenList(head);
		printList(oddEven);
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
