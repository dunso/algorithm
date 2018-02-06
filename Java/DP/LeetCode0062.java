
public class LeetCode0062 {
	public int uniquePaths(int m, int n) {
		if (m < 1 || n < 1) {
			return 0;
		}
		int[][] dp = new int[m][n];

		dp[0][0] = 1;

		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0];
		}

		for (int j = 1; j < n; j++) {
			dp[0][j] = dp[0][j - 1];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		LeetCode0062 leetcode = new LeetCode0062();
		System.out.println(leetcode.uniquePaths(3, 7));
	}
}
