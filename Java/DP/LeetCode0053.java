public class LeetCode0053 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode0053 leetcode = new LeetCode0053();
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(leetcode.maxSubArray(nums));
    }
}
