
public class LeetCode0061 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null || k == 0) {
			return head;
		}

		ListNode p = head;
		int n = 1;

		for (; p.next != null; n++) {
			p = p.next;
		}

		ListNode lastNode = p;

		k %= n;
		if (k == 0) {
			return head;
		}

		k = n - k;
		ListNode q = head;
		p = head.next;

		for (int i = 1; p != null && i < k; i++) {
			q = p;
			p = p.next;
		}

		q.next = null;
		lastNode.next = head;
		return p;
	}
}
