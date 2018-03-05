public class LeetCode0079 {

	private final int[][] direction = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
			return false;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int i, int j, String word, int pos) {

		if (pos >= word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}
		if (word.charAt(pos) != board[i][j]) {
			return false;
		}
		board[i][j] = '#';
		for (int k = 0; k < direction.length; k++) {
			if (dfs(board, i + direction[k][0], j + direction[k][1], word, pos + 1)) {
				return true;
			}
		}
		board[i][j] = word.charAt(pos);
		return false;
	}

	public static void main(String[] args) {
		LeetCode0079 leetcode = new LeetCode0079();
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(leetcode.exist(board, "SEE"));
	}
}