public class LeetCode0581 {

    public int findUnsortedSubarray(int[] nums)
    {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int right = 0;
        int left = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                continue;
            }
            right = i;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] <= min) {
                min = nums[j];
                continue;
            }
            left = j;
        }
        return left >= right ? 0 : right - left + 1;
    }

    public static void main(String[] args)
    {
        LeetCode0581 leetcode = new LeetCode0581();
        int[] nums = new int[] { 2, 6, 4, 8, 10, 9, 15 };
        System.out.println(leetcode.findUnsortedSubarray(nums));
    }
}