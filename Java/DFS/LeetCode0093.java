import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0093 {
	
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12) {
			return result;
		}
		dfs(s, 0, result, new StringBuilder(), 0);
		return result;
	}

	private void dfs(String s, int start, List<String> result, StringBuilder current, int count) {

		if (count == 4) {
			if (start >= s.length()) {
				result.add(current.substring(1).toString());
			} else {
				return;
			}
		}

		for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
			String numStr = s.substring(start, start + i);
			int num = Integer.parseInt(numStr);
			if (num <= 255) {
				current.append(".").append(numStr);
				dfs(s, start + i, result, current, count + 1);
				current.delete(current.length() - 1 - numStr.length(), current.length());
			}
			if (num == 0) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		LeetCode0093 leetcode = new LeetCode0093();
		System.out.println(Arrays.toString(leetcode.restoreIpAddresses("010010").toArray()));
	}
}