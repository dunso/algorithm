import java.util.Arrays;

public class LeetCode0561 {
	public int arrayPairSum(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);

		int result = 0;
		for (int i = 0; i < nums.length; i += 2) {
			result += nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode0561 leetcode = new LeetCode0561();
		int[] nums = new int[] { 1, 4, 3, 2 };
		System.out.println(leetcode.arrayPairSum(nums));
	}
}
