import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class LeetCode0023 {
	public ListNode mergeKLists(ListNode[] lists) {
		
		if(lists == null || lists.length == 0){
			return null;
		}
		
		Comparator<ListNode> compare = new Comparator<ListNode>(){
			@Override
			public int compare(ListNode c1, ListNode c2) {
				return c1.val - c2.val;
			}
		};
		 
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, compare);
		
		ListNode head = new ListNode(0);
		ListNode tail = head;
		
		for(ListNode listNode: lists){
			if(listNode != null){
				queue.add(listNode);
			}
		}
		
		while(!queue.isEmpty()){
			tail.next = queue.poll();
			tail = tail.next;
			
			if(tail.next != null){
				queue.add(tail.next);
			}
		}
		return head.next;
    }
	
	@Test
	public void test(){
		ListNode ln11 = new ListNode(1);
		ListNode ln12 = new ListNode(2);
		ListNode ln13 = new ListNode(2);
		ln11.next = ln12;
		ln12.next = ln13;
		ln13.next = null;
		
		ListNode ln21 = new ListNode(1);
		ListNode ln22 = new ListNode(1);
		ListNode ln23 = new ListNode(2);
		ln21.next = ln22;
		ln22.next = ln23;
		ln23.next = null;
		
		ListNode[] listNode = {ln11, ln21};
		
		ListNode result = mergeKLists(listNode);
		
		while(result != null){
			System.out.print(result.val);
			result = result.next;
		}
	}
}
