import org.junit.Test;

public class LeetCode0329 {

	private int[][] matrix;
	private int rowLength;
	private int colLength;
	private int[][] cache;
	
	public int longestIncreasingPath(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		this.matrix = matrix;
		rowLength = matrix.length;
		colLength = matrix[0].length;
		cache = new int[rowLength][colLength];
		int max = 0;
		for(int i = 0; i< rowLength; i++){
			for(int j = 0; j < colLength; j++){
				max = Math.max(max, dfs(i, j));
			}
		}
		return max;
	}
	
	private int dfs(int i, int j){
		if(cache[i][j] != 0){
			return cache[i][j];
		}
		int max = 0; 
		if(i > 0 && matrix[i][j] < matrix[i-1][j]){
			max = Math.max(max, dfs(i - 1, j));
		}
		if(i + 1 < rowLength && matrix[i][j] < matrix[i+1][j]){
			max = Math.max(max, dfs(i+1, j));
		}
		if(j > 0 && matrix[i][j] < matrix[i][j-1]){
			max = Math.max(max, dfs(i, j - 1));
		}
		if(j + 1 < colLength && matrix[i][j] < matrix[i][j + 1]){
			max = Math.max(max, dfs(i, j + 1));
		}
		cache[i][j] = max + 1;
		return max + 1;
	}
	
	@Test
	public void test(){
		int[][] matrix = {
				{9,9,4},
				{6,6,8},
				{2,1,1}
		};
		System.out.println(longestIncreasingPath(matrix));
	}
}
