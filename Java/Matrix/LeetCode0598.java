public class LeetCode0598 {
    public int maxCount(int m, int n, int[][] ops)
    {
        if (m <= 0 || n <= 0 || ops == null) {
            return 0;
        }

        int minRow = m;
        int minCol = n;
        for (int i = 0; i < ops.length; i++) {
            if (minRow > ops[i][0]) {
                minRow = ops[i][0];
            }
            if (minCol > ops[i][1]) {
                minCol = ops[i][1];
            }
        }

        return minRow * minCol;
    }

    public static void main(String[] args)
    {
        LeetCode0598 leetcode = new LeetCode0598();
        int ops[][] = { { 2, 2 }, { 3, 3 } };

        System.out.println(leetcode.maxCount(3, 3, ops));
    }
}