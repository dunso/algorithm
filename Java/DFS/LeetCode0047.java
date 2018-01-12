import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode0047 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null) {
			return result;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		Set<String> resultSet = new HashSet<String>();

		dfs(nums, map, new ArrayList<Integer>(), result, resultSet);
		return result;
	}

	private void dfs(int[] nums, Map<Integer, Integer> map, List<Integer> current, List<List<Integer>> result,
			Set<String> resultSet) {

		if (map.size() == 0) {

			String str = listToString(current);
			if (resultSet.contains(str)) {
				return;
			}
			result.add(new ArrayList<Integer>(current));
			resultSet.add(str);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				current.add(nums[i]);
				if (map.get(nums[i]) - 1 == 0) {
					map.remove(nums[i]);
				} else {
					map.put(nums[i], map.get(nums[i]) - 1);
				}
				dfs(nums, map, current, result, resultSet);
				map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
				current.remove(current.size() - 1);
			}
		}
	}

	private String listToString(List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		return sb.toString();
	}
}
