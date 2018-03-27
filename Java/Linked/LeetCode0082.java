public class LeetCode0082 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dammy = new ListNode(Integer.MIN_VALUE);
		ListNode current = dammy;
		ListNode pre = head;
		ListNode detect = head.next;

		int duplicate = Integer.MIN_VALUE;

		for (; detect != null; pre = detect, detect = detect.next) {
			if (pre.val == detect.val) {
				duplicate = pre.val;
			} else {
				if (duplicate != Integer.MIN_VALUE) {
					duplicate = Integer.MIN_VALUE;
				} else {
					current.next = pre;
					current = pre;
				}
			}
		}

		if (duplicate == Integer.MIN_VALUE) {
			current.next = pre;
			current = pre;
		}

		current.next = null;
		return dammy.next;
	}
}