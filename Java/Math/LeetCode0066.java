import java.util.Arrays;

public class LeetCode0066 {
	public int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0) {
			return digits;
		}

		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			carry += digits[i];
			digits[i] = carry % 10;
			carry /= 10;
		}

		if (carry == 0) {
			return digits;
		}

		else {
			int[] tmp = new int[digits.length + 1];
			tmp[0] = carry;
			System.arraycopy(digits, 0, tmp, 1, digits.length);
			return tmp;
		}
	}

	public static void main(String[] args) {
		LeetCode0066 leetcode = new LeetCode0066();
		int[] digits = new int[] { 9, 9, 9 };
		System.out.println(Arrays.toString(leetcode.plusOne(digits)));
	}
}
