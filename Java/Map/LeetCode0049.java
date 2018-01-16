import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode0049 {
	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<List<String>>();

		if (strs == null || strs.length == 0) {
			return result;
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			String array[] = str.split("");
			Arrays.sort(array);
			String hash = Arrays.toString(array);
			if (map.containsKey(hash)) {
				map.get(hash).add(str);
			} else {
				map.put(hash, new ArrayList<String>());
				map.get(hash).add(str);
			}
		}
		result.addAll(map.values());
		return result;
	}

	public static void main(String[] args) {
		LeetCode0049 leetcode = new LeetCode0049();
		List<List<String>> result = leetcode.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
