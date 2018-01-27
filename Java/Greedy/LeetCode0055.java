
public class LeetCode0055 {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		int longestSkip = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			if (i > longestSkip) {
				return false;
			}
			if (i + nums[i] > longestSkip) {
				longestSkip = i + nums[i];
			}
			if (longestSkip >= nums.length - 1) {
				return true;
			}
		}
		return longestSkip >= nums.length - 1;
	}

	public static void main(String[] args) {
		LeetCode0055 leetcode = new LeetCode0055();
		System.out.println(leetcode.canJump(new int[] { 3, 0, 8, 2, 0, 0, 1 }));
	}
}
