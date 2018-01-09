public class LeetCode0576 {

    private final int MOD = 1000000007;
    private int N;
    private static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int findPaths(int m, int n, int N, int i, int j)
    {

        if (m <= 0 || n <= 0 || N == 0 || i < 0 || j < 0) {
            return 0;
        }

        this.N = N;

        int[][][] dp = new int[m][n][N + 1];
        return DFS(0, i, j, m, n, dp);
    }

    private int DFS(int step, int i, int j, int m, int n, int[][][] dp)
    {

        if (i < 0 || i == m || j < 0 || j == n) {
            return 1;
        }

        if (step == N) {
            return 0;
        }

        int remain = N - step;

        if (i - remain >= 0 && i + remain < m && j - remain >= 0 && j + remain < n) {
            return 0;
        }

        if (dp[i][j][step] > 0) {
            return dp[i][j][step];
        }

        for (int k = 0; k < dirs.length; k++) {
            dp[i][j][step] += DFS(step + 1, i + dirs[k][0], j + dirs[k][1], m, n, dp) % MOD;
            dp[i][j][step] %= MOD;
        }
        return dp[i][j][step];
    }

    public static void main(String[] args)
    {
        LeetCode0576 solution = new LeetCode0576();
        System.out.println(solution.findPaths(2, 2, 2, 0, 0));
    }
}