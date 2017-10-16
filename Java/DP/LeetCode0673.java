
public class LeetCode0673 {

	public int findNumberOfLIS(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int len[] = new int[nums.length + 1];
		int count[] = new int[nums.length + 1];

		int maxLen = 0;
		int result = 0;

		for (int i = 0; i < nums.length; i++) {
			len[i] = count[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (len[i] == len[j] + 1) {
						count[i] += count[j];
					} else if (len[i] < len[j] + 1) {
						len[i] = len[j] + 1;
						count[i] = count[j];
					}
				}
			}
			if (maxLen == len[i]) {
				result += count[i];
			} else if (maxLen < len[i]) {
				maxLen = len[i];
				result = count[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode0673 leetcode = new LeetCode0673();
		int[] nums = new int[] { 2, 2, 2, 2, 2 };
		System.out.println(leetcode.findNumberOfLIS(nums));
	}

}
