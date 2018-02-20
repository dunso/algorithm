
public class LeetCode0067 {

	public String addBinary(String a, String b) {
		if (a == null || b == null) {
			return null;
		}

		if (a.length() == 0) {
			return b;
		} else if (b.length() == 0) {
			return a;
		}

		StringBuilder sb = new StringBuilder();
		int carry = 0, aInt = 0, bInt = 0;

		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {

			aInt = i < 0 ? 0 : a.charAt(i) - '0';
			bInt = j < 0 ? 0 : b.charAt(j) - '0';

			sb.append(aInt ^ bInt ^ carry);
			carry = aInt + bInt + carry > 1 ? 1 : 0;
		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		LeetCode0067 leetcode = new LeetCode0067();
		System.out.println(leetcode.addBinary("11", "1"));
	}
}
