
public class LeetCode0058 {
	public int lengthOfLastWord(String s) {
		if (s.length() == 0) {
			return 0;
		}

		boolean hasWord = false;
		int result = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (!hasWord) {
				if (s.charAt(i) == ' ') {
					continue;
				} else {
					hasWord = true;
					result++;
					continue;
				}
			}
			if (hasWord) {
				if (s.charAt(i) != ' ') {
					result++;
				} else {
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode0058 leetcode = new LeetCode0058();
		System.out.println(leetcode.lengthOfLastWord("Hello World"));
	}
}
