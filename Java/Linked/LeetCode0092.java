public class LeetCode0092 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m >= n) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode pre = dummy;

		int count = 1;
		while (count < m && pre.next != null) {
			count++;
			pre = pre.next;
		}

		ListNode first = pre;
		pre = pre.next;
		ListNode p = pre.next;

		while (count < n && p != null) {
			pre.next = p.next;
			p.next = first.next;
			first.next = p;
			p = pre.next;
			count++;
		}

		return dummy.next;
	}
}