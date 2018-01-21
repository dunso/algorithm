import java.util.Arrays;

public class LeetCode0031 {
	
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int max = nums[nums.length - 1];

		for (int i = nums.length - 2; i >= 0; i--) {
			
			if(nums[i] >= max) {
				max = nums[i];
				continue;
			}

			int moreMax = Integer.MAX_VALUE;
			int index = -1;

			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i] && nums[j] < moreMax) {
					moreMax = nums[j];
					index = j;
				}
			}

			nums[i] ^= nums[index];
			nums[index] ^= nums[i];
			nums[i] ^= nums[index];
			
			Arrays.sort(nums, i + 1, nums.length);
			
			return;			
		}

		Arrays.sort(nums);
		return;
	}

	public static void main(String[] args) {
		LeetCode0031 leetcode = new LeetCode0031();
		int[] nums = new int[] { 2, 3, 1 };
		leetcode.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
