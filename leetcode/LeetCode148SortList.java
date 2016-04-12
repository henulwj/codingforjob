package codingforjob.leetcode;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

/***
 * 思路：采用归并排序的方式对链表进行排序
 * @author lwj
 *
 */


public class LeetCode148SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(3);
		head.next = new ListNode(1);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(2);
		head = sortList(head);
		while(head!= null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	
	public static ListNode sortList(ListNode head) {
        if(head == null)
        	return null;
        if(head.next == null)
        	return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next !=null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
		ListNode h2 = slow.next;
		slow.next = null;
		return mergeSortList(sortList(head), sortList(h2));
    }
	
	
	
	public static ListNode mergeSortList(ListNode h1, ListNode h2){
		
		ListNode head = new ListNode(0);
		ListNode c = head;
		while(h1 != null && h2 != null){
			if(h1.val <= h2.val){
				c.next = h1;
				h1 = h1.next;
			}
			else{
				c.next = h2;
				h2 = h2.next;
			}
			c = c.next;
		}
		if(h1 == null){
			c.next = h2;
		}
		else{
			c.next = h1;
		}
		return head.next;
	}

}
