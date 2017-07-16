import java.util.Arrays;
import org.junit.Test;

public class LeetCode0300 {

	public int lengthOfLIS(int[] nums) {
		int dp[] = new int[nums.length];
		int length = 0;
		for (int i = 0; i < nums.length; i++) {
			int index = Arrays.binarySearch(dp, 0, length, nums[i]);
			if (index < 0) {
				index = -index - 1;
			}
			dp[index] = nums[i];
			if (index == length) {
				length++;
			}
		}
		return length;
	}

	@Test
	public void test() {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}
}
