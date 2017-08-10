public class Solution {
   public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (length == n) {
            return head.next;
        }
        int target = length - n -1;
        if (target < 0) {
            return null;
        }
        cur = head;
        while (target > 0) {
            cur = cur.next;
            target--;
        }
        
        cur.next = cur.next.next;
        
        return head;
    }
}
