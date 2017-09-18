import java.util.HashMap;
import java.util.Map;

public class LeetCode0594 {

    public int findLHS(int[] nums)
    {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int result = 0;

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key + 1) + map.get(key));
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        LeetCode0594 leetcode = new LeetCode0594();
        System.out.println(leetcode.findLHS(new int[] { 1, 3, 2, 2, 5, 2, 3, 7 }));
    }
}