import java.util.ArrayList;
import java.util.List;

public class LeetCode0089 {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		if (n < 0) {
			return result;
		}
		if (n == 0) {
			result.add(0);
			return result;
		}

		List<Integer> res = grayCode(n - 1);
		result.addAll(res);
		int num = 1 << (n - 1);
		for (int i = res.size() - 1; i >= 0; i--) {
			result.add(num + res.get(i));
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode0089 leetcode = new LeetCode0089();
		System.out.println(leetcode.grayCode(2));
	}
}