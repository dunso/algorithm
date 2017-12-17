public class LeetCode0029 {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (divisor == -1 && dividend == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}

		long pDividend = Math.abs((long) dividend);
		long pDivisor = Math.abs((long) divisor);

		int result = 0;

		while (pDividend >= pDivisor) {
			int shift = 1;
			while (pDividend >= (pDivisor << shift)) {
				shift++;
			}
			shift--;
			result += 1 << shift;
			pDividend -= pDivisor << shift;
		}

		if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
			return result;
		} else {
			return -result;
		}
	}

	public static void main(String[] args) {
		LeetCode0029 leetcode = new LeetCode0029();
		System.out.println(leetcode.divide(9, 2));
	}
}