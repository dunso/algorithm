public class LeetCode0070 {
    
    public int climbStairs(int n)
    {
        if (n == 1 || n == 2) {
            return n;
        }

        int pre1 = 2, pre2 = 1, sum = 0;

        for (int k = 3; k <= n; k++) {
            sum = pre1 + pre2;
            pre2 = pre1;
            pre1 = sum;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        LeetCode0070 leetcode = new LeetCode0070();
        System.out.println(leetcode.climbStairs(4));
    }
}
