public class LeetCode0026 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
            }
            nums[i] = nums[j];
        }
        return i+1;
    }

    public static void main(String[] args) {
        LeetCode0026 leetcode = new LeetCode0026();
        int[] nums = new int[] { 1, 1, 2 };
        System.out.println(leetcode.removeDuplicates(nums));
    }

}
