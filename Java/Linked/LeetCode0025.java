import org.junit.Test;

/*class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }*/

public class LeetCode0025 {
	public ListNode reverseKGroup(ListNode head, int k) {
		
		if(k == 1 || head == null){
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode start = dummy;
		while(start != null){
			start = reverseKNode(start, k);
		}
        return dummy.next;
    }
	
	private ListNode reverseKNode(ListNode start, int k){
		ListNode end = start;
		
		int i = k;
		while(i--  > 0 && end.next != null){
			end = end.next;
		}
		if(i >= 0){
			return null;
		}
				
		ListNode current = start.next.next, preNode = start.next;
		
		while(--k > 0){
			ListNode tmp = current.next;
			current.next = preNode;
			preNode = current;
			current = tmp;
		}
		end = start.next;
		end.next = current;
		start.next = preNode;
		
		return end;
	}
	
	@Test
	public void test(){
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ln1.next = ln2;
		ln2.next = ln3;
		ListNode result = reverseKGroup(ln1, 3);
		while(result != null){
			System.out.print(result.val);
			result = result.next;
		}
	}
}