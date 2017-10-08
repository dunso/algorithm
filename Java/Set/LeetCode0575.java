import java.util.HashSet;
import java.util.Set;

public class LeetCode0575 {
    public int distributeCandies(int[] candies)
    {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        int total = candies.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
            if (set.size() == total) {
                return total;
            }
        }
        return set.size();
    }

    public static void main(String[] args)
    {
        LeetCode0575 leetcode = new LeetCode0575();
        int[] candies = new int[] { 1, 1, 2, 3 };
        System.out.println(leetcode.distributeCandies(candies));
    }
}