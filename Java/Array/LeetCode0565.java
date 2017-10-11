public class LeetCode0565 {
    public int arrayNesting(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        int half = nums.length >> 1;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; nums[j] != -1; count++) {
                int tmp = nums[j];
                nums[j] = -1;
                j = tmp;
            }
            if (count > half) {
                return count;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static void main(String[] args)
    {
        LeetCode0565 leetcode = new LeetCode0565();
        int[] nums = new int[] { 5, 4, 0, 3, 1, 6, 2 };
        System.out.println(leetcode.arrayNesting(nums));
    }
}