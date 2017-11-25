public class LeetCode0024 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        swap(dummy);
        return dummy.next;
    }

    private void swap(ListNode p1)
    {
        if (p1 == null) {
            return;
        }
        ListNode p2 = p1.next;
        if (p2 == null) {
            return;
        }

        ListNode p3 = p2.next;
        if (p3 == null) {
            return;
        }

        p2.next = p3.next;
        p3.next = p2;
        p1.next = p3;       
        swap(p2);
    }
}
