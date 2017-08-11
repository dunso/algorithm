import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode0018 {

	class Tuple<X, Y> {
		public X x;
		public Y y;

		public Tuple() {
		}

		public Tuple(X x, Y y) {
			this.x = x;
			this.y = y;
		}
	}

	public List<List<Integer>> fourSum(int[] num, int target) {

		final List<List<Integer>> result = new ArrayList<>();
		final int length;

		if (num == null || (length = num.length) < 4) {
			return result;
		}

		Arrays.sort(num);

		if ((num[0] << 2) > target || (num[length - 1] << 2) < target) {
			return result;
		}

		Set<List<Integer>> reseltSet = new HashSet<>();
		DivideSum2(num, target, reseltSet);

		return new ArrayList<List<Integer>>(reseltSet);
	}

	private void DivideSum2(int[] num, int target, Set<List<Integer>> reseltSet) {

		Map<Integer, List<Tuple<Integer, Integer>>> map = new HashMap<>();

		for (int i = 0; i < num.length; i++) {

			if (i > 1 && num[i] == num[i - 2]) {
				continue;
			}
			for (int j = i + 1; j < num.length; j++) {

				if (j > i + 2 && num[j] == num[j - 2]) {
					continue;
				}

				int sum21 = num[i] + num[j];
				int sum22 = target - sum21;

				if (map.containsKey(sum22)) {
					check(num, map.get(sum22), i, j, reseltSet);
				}

				List<Tuple<Integer, Integer>> list = map.get(sum21);
				if (list == null) {
					list = new ArrayList<>();
					map.put(num[i] + num[j], list);
				}
				list.add(new Tuple<Integer, Integer>(i, j));
			}
		}
	}

	private void check(int[] nums, List<Tuple<Integer, Integer>> list, int index1, int index2,
			Set<List<Integer>> results) {

		for (Tuple<Integer, Integer> tuple : list) {

			if (tuple.x == index1 || tuple.x == index2 || tuple.y == index1 || tuple.y == index2) {
				continue;
			} else {
				List<Integer> result = Arrays.asList(nums[tuple.x], nums[tuple.y], nums[index1], nums[index2]);
				Collections.sort(result);
				results.add(result);
			}
		}
	}

	public static void main(String[] args) {
		LeetCode0018 leetcode = new LeetCode0018();
		int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };

		List<List<Integer>> results = leetcode.fourSum(nums, 0);

		for (List<Integer> list : results) {
			for (Integer number : list) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}
