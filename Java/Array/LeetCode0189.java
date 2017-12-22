import java.util.Arrays;

public class LeetCode0189 {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0) {
			return;
		}

		k %= nums.length;

		reverse(nums, 0, nums.length - 1 - k);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);

	}

	private void reverse(int[] array, int start, int end) {
		int mid = (end - start) >> 1;
		for (int i = 0; i <= mid; i++) {
			if (array[start + i] == array[end - i]) {
				continue;
			}
			array[start + i] ^= array[end - i];
			array[end - i] ^= array[start + i];
			array[start + i] ^= array[end - i];
		}
	}

	public static void main(String[] args) {
		LeetCode0189 leetcode = new LeetCode0189();
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		leetcode.rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
}