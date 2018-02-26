
public class LeetCode0083 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode p = head;
		ListNode pre = dummy;
		while (p != null) {
			if (p.val == pre.val) {
				p = p.next;
			} else {
				pre.next = p;
				pre = p;
				p = p.next;
			}
		}
		pre.next = null;
		return dummy.next;
	}
}
