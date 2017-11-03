import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode0239 {
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        if (k == 0 || nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> deque = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        LeetCode0239 leetcode = new LeetCode0239();
        int[] nums = new int[] { 1, 3, 1, 2, 0, 5 };
        System.out.println(Arrays.toString(leetcode.maxSlidingWindow(nums, 3)));
    }
}