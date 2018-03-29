public class LeetCode0086 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode record = dummy;
		ListNode pre = dummy;
		ListNode p = head;
		while (p != null) {
			if (p.val < x) {
				if (record != pre) {
					pre.next = p.next;
					p.next = record.next;
					record.next = p;
					record = p;
					p = pre.next;
				} else {
					pre = p;
					p = p.next;
					record = pre;
				}

			} else {
				pre = p;
				p = p.next;
			}
		}
		return dummy.next;
	}
}