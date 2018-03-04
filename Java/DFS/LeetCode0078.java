import java.util.ArrayList;
import java.util.List;

public class LeetCode0078 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		dfs(0, nums, new ArrayList<Integer>(), result);
		result.add(new ArrayList<Integer>());
		return result;
	}

	private void dfs(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {

		if (index >= nums.length) {
			return;
		}

		current.add(nums[index]);
		result.add(new ArrayList<>(current));
		dfs(index + 1, nums, current, result);
		current.remove(current.size() - 1);
		dfs(index + 1, nums, current, result);
	}

	public static void main(String[] args) {
		LeetCode0078 leetcode = new LeetCode0078();
		List<List<Integer>> result = leetcode.subsets(new int[] { 1, 2, 3 });
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
