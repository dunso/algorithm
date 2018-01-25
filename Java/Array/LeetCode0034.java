
public class LeetCode0034 {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] { -1, -1 };
		if (nums == null || nums.length == 0) {
			return result;
		}

		int left = 0, right = nums.length - 1, mid = -1;

		while (left <= right) {
			mid = left + ((right - left) >> 1);
			if (nums[mid] == target) {
				break;
			}
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		if (left > right) {
			return result;
		}

		for (left = mid; left >= 0 && nums[left] == target; left--)
			;
		for (right = mid; right < nums.length && nums[right] == target; right++)
			;

		result[0] = left < 0 ? 0 : nums[left] == target ? left : left + 1;
		result[1] = right == nums.length ? nums.length - 1 : nums[right] == target ? right : right - 1;
		return result;
	}

	public static void main(String[] args) {
		LeetCode0034 leetcode = new LeetCode0034();
		int[] result = leetcode.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 9);
		System.out.println(result[0] + " , " + result[1]);
	}
}
