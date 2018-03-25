public class LeetCode0081 {

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] == target) {
				return true;
			} else if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left++;
				}
			} else {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right--;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LeetCode0081 leetcode = new LeetCode0081();
		System.out.println(leetcode.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
	}
}
