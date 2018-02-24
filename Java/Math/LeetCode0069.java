public class LeetCode0069 {
	public int mySqrt(int x) {
		if (x <= 0) {
			return x;
		}
		int result = 0;
		int left = 1, right = x;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (mid <= x / mid) {
				left = mid + 1;
				result = mid;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode0069 leetcode = new LeetCode0069();
		System.out.println(leetcode.mySqrt(1));
	}
}