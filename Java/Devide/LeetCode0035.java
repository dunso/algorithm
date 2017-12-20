public class LeetCode0035 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length;
        while (i < j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        LeetCode0035 leetcode = new LeetCode0035();
        int[] nums = new int[] { 1, 3, 5, 6 };
        System.out.println(leetcode.searchInsert(nums, 0));
    }
}
