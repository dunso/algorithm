import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0090 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		dfs(nums, 0, result, new ArrayList<Integer>());
		return result;
	}

	private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> current) {
		result.add(current);
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1]) {
				continue;
			}
			current.add(nums[i]);
			dfs(nums, i + 1, result, new ArrayList<Integer>(current));
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		LeetCode0090 leetcode = new LeetCode0090();
		List<List<Integer>> result = leetcode.subsetsWithDup(new int[] { 1, 2, 2 });
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j));
			}
			System.out.println();
		}
	}
}