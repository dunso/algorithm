import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode0047 {

	public List<List<Integer>> permuteUnique(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		result.add(new ArrayList<Integer>());

		for (int i = 0; i < nums.length; i++) {
			
			Set<List<Integer>> currentSet = new HashSet<List<Integer>>();
			
			for (List<Integer> pre : result) {
				for (int j = 0; j < pre.size() + 1; j++) {
					
					pre.add(j, nums[i]);
					
					List<Integer> newList = new ArrayList<Integer>(pre);
					
					pre.remove(j);
					
					currentSet.add(newList);
				}
			}
			result = new ArrayList<List<Integer>>(currentSet);
		}

		return result;
	}
	
	public static void main(String[] args) {
		LeetCode0047 leetcode = new LeetCode0047();
		List<List<Integer>> result = leetcode.permuteUnique(new int[] { 1,-1,1,2,-1,2,2,-1 });
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
