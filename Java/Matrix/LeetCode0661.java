public class LeetCode0661 {

	private int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
			{ 1, 1 }, { 0, 0 } };

	public int[][] imageSmoother(int[][] M) {
		if (M == null || M.length == 0 || M[0].length == 0) {
			return M;
		}

		int rowLength = M.length;
		int colLength = M[0].length;

		int[][] result = new int[rowLength][colLength];

		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				result[i][j] = fill(i, j, rowLength, colLength, M);
			}
		}
		return result;
	}

	private int fill(int x, int y, int rowLength, int colLength, int[][] M) {
		int i = x, j = y;
		int total = 0;
		int count = 0;
		for (int k = 0; k < dir.length; k++) {
			i = x + dir[k][0];
			j = y + dir[k][1];

			if (i >= 0 && i < rowLength && j >= 0 && j < colLength) {
				total++;
				count += M[i][j];
			}
		}
		return count / total;
	}

	public static void main(String[] args) {
		LeetCode0661 leetcode = new LeetCode0661();
		int[][] M = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int[][] result = leetcode.imageSmoother(M);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
