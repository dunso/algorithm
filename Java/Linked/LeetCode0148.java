public class LeetCode0148 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
        }
    }

    public ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h = new ListNode(Integer.MIN_VALUE);
        h.next = head;
        sort(h, null);
        return h.next;
    }

    private void sort(ListNode head, ListNode endNext)
    {

        if (head == null || head.next == null || head.next == endNext || head.next.next == endNext) {
            return;
        }

        ListNode midNode = head.next;
        ListNode currentNode = midNode.next;

        boolean isLeftNeedSort = false;
        boolean isRightNeedSort = false;

        for (ListNode preNode = midNode; currentNode != endNext; currentNode = preNode.next) {

            if (currentNode.val < midNode.val) {

                if (!isLeftNeedSort && head.next.val < currentNode.val) {
                    isLeftNeedSort = true;
                }
                preNode.next = currentNode.next;
                currentNode.next = head.next;
                head.next = currentNode;
            } else {
                if (!isRightNeedSort && preNode.val > currentNode.val) {
                    isRightNeedSort = true;
                }
                preNode = preNode.next;
            }
        }

        if (isLeftNeedSort) {
            sort(head, midNode);
        }
        if (isRightNeedSort) {
            sort(midNode, currentNode);
        }
    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(8);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(7);
        ListNode l7 = new ListNode(13);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        LeetCode0148 leetcode = new LeetCode0148();

        ListNode head = leetcode.sortList(l1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}