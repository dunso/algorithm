public class LeetCode0027 {
    public int removeElement(int[] nums, int val)
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int length = nums.length;
        while (i < length) {
            if (nums[i] == val) {
                nums[i] = nums[--length];
            }
            else {
                i++;
            }
        }
        return length;
    }

    public static void main(String[] args)
    {
        LeetCode0027 leetcode = new LeetCode0027();
        int[] nums = new int[] { 3, 2, 2, 3 };
        System.out.println(leetcode.removeElement(nums, 3));
    }
}
