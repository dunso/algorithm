import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode0046 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null) {
			return result;
		}

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		dfs(nums, set, new ArrayList<Integer>(), result);
		return result;
	}

	private void dfs(int[] nums, HashSet<Integer> set, List<Integer> current, List<List<Integer>> result) {
		if (set.size() == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				current.add(nums[i]);
				set.remove(nums[i]);
				dfs(nums, set, current, result);
				set.add(nums[i]);
				current.remove(current.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		LeetCode0046 leetcode = new LeetCode0046();
		List<List<Integer>> result = leetcode.permute(new int[] { 1, 2, 3 });
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
