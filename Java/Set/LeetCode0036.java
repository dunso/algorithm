import java.util.HashSet;
import java.util.Set;

public class LeetCode0036 {

	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0] == null || board[0].length != 9) {
			return false;
		}

		Set<Character>[][] block = new HashSet[3][3];

		for (int i = 0; i < 9; i++) {

			Set<Character> row = new HashSet<Character>();
			Set<Character> col = new HashSet<Character>();

			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.' && !col.add(board[j][i])) {
					return false;
				}

				if (board[i][j] == '.') {
					continue;
				}

				if (!row.add(board[i][j])) {
					return false;
				}

				if (block[i / 3][j / 3] == null) {
					block[i / 3][j / 3] = new HashSet<Character>();
				}
				if (!block[i / 3][j / 3].add(board[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		LeetCode0036 leetcode = new LeetCode0036();
		System.out.println(leetcode.isValidSudoku(new char[][] { { '.', '8', '7', '6', '5', '4', '3', '2', '1' },
				{ '2', '.', '.', '.', '.', '.', '.', '.', '.' }, { '3', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '4', '.', '.', '.', '.', '.', '.', '.', '.' }, { '5', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '6', '.', '.', '.', '.', '.', '.', '.', '.' }, { '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '8', '.', '.', '.', '.', '.', '.', '.', '.' }, { '9', '.', '.', '.', '.', '.', '.', '.', '.' } }));
	}
}
