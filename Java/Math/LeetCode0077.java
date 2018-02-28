import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode0077 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n == 0 || k == 0 || n < k) {
			return result;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= n; i++) {
			set.add(i);
		}
		dfs(n, k, result, new LinkedList<Integer>(), set);
		return result;

	}

	private void dfs(int n, int k, List<List<Integer>> result, LinkedList<Integer> current, Set<Integer> set) {

		if (current.size() == k) {
			result.add(new LinkedList<Integer>(current));
			return;
		}

		for (int i = current.isEmpty() ? 1 : current.getLast(); i <= n; i++) {
			if (set.contains(i)) {
				current.add(i);
				set.remove(i);
				dfs(n, k, result, current, set);
				current.removeLast();
				set.add(i);
			}
		}
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
