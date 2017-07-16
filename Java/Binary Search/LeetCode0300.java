import org.junit.Test;

public class LeetCode0300_1 {
	
	public int lengthOfLIS(int[] nums) {
		
		int[] dp = new int[nums.length];
		int length = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (length == 0 || dp[length - 1] < nums[i]) {
				dp[length] = nums[i];
				length++;
				continue;
			} 
			
			int left = 0, right = length - 1;
			while (left < right) {
				int mid = left + ((right - left) >> 1);
				if (dp[mid] < nums[i]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			dp[left] = nums[i];
			
		}
		return length;
	}

	@Test
	public void test() {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}
}
