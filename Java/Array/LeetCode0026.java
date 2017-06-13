
class LeetCode0026 {
	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            int temp = nums[0];
            int len = 1;
            for (int i = 1; i < nums.length; i++) {
                if (temp == nums[i]) {
                    continue;
                } else {
                    temp = nums[i];
                    nums[len] = nums[i];
                    len++;
                }
            }
            return len;
        }
    }
}
