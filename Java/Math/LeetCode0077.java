import java.util.ArrayList;
import java.util.List;

public class LeetCode0077 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n == 0 || k == 0 || n < k) {
			return result;
		}
		dfs(1, n, k, result, new ArrayList<Integer>());
		return result;
	}

	private void dfs(int start, int n, int k, List<List<Integer>> result, ArrayList<Integer> current) {
		if (k == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}

		if (start > n) {
			return;
		}

		current.add(start);
		dfs(start + 1, n, k - 1, result, current);
		current.remove(current.size() - 1);
		dfs(start + 1, n, k, result, current);
	}

	public static void main(String[] args) {
		LeetCode0077 leetcode = new LeetCode0077();
		List<List<Integer>> result = leetcode.combine(4, 2);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
