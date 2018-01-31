
import java.util.Arrays;

public class LeetCode0059 {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int firstRow = 0, lastRow = n - 1, firstCol = 0, lastCol = n - 1;

		int num = 1;
		while (num <= n * n) {
			for (int j = firstCol; j <= lastCol; j++) {
				result[firstRow][j] = num++;
			}
			firstRow++;
			for (int i = firstRow; i <= lastRow; i++) {
				result[i][lastCol] = num++;
			}
			lastCol--;
			for (int j = lastCol; j >= firstCol; j--) {
				result[lastRow][j] = num++;
			}
			lastRow--;
			for (int i = lastRow; i >= firstRow; i--) {
				result[i][firstCol] = num++;
			}
			firstCol++;
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode0059 leetcode = new LeetCode0059();
		int n = 3;
		int[][] result = leetcode.generateMatrix(n);
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
