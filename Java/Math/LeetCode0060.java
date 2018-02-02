import java.util.ArrayList;
import java.util.List;

public class LeetCode0060 {
	public String getPermutation(int n, int k) {
		if (n < 0 || k < 0) {
			return null;
		}
		List<Integer> numList = new ArrayList<Integer>();
		int fractorial = 1;
		for (int i = 1; i <= n; i++) {
			numList.add(i);
			fractorial *= i;
		}
		k--;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			fractorial /= n - i;
			int index = k / fractorial;
			sb.append(numList.get(index));
			numList.remove(index);
			k %= fractorial;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LeetCode0060 leetcode = new LeetCode0060();
		System.out.println(leetcode.getPermutation(3, 4));
	}
}
