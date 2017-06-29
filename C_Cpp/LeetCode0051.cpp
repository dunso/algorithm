#include <string>
#include <vector>
#include <iostream>

using namespace std;

class LeetCode0051 {
public:
	vector<vector<string>> solveNQueens(int n) {

		vector<int> row(n);
		vector<int> col(n);

		vector<vector<int> > diagonal(n);

		vector<vector<char> > board(n);
		for (auto i = 0; i < n; i++)
		{
			diagonal[i].resize(n);
			board[i].resize(n);
		}

		for(auto i = 0; i< n; i++)
		{
			for(auto j = 0; j < n; j++)
			{
				board[i][j] = '.';
			}
		}

		vector<vector<string> > res;

		findNextOne(res, board, row, col, diagonal, 0, 0, n);

		return res;

	}

	static void findNextOne(vector<vector<string> > &res, vector<vector<char> > &board,
		vector<int> row, vector<int> col, vector<vector<int> > diagonal, int i, int j, int n)
	{
		if (i == n)
		{
			vector<string> solution;
			for (auto a = 0; a < n; a++)
			{
				string line(board[a].begin(), board[a].end());
				solution.push_back(line);
			}

			res.push_back(solution);

			return;
		}

		for (int y = j; y < n; y++)
		{
			if (row[i] == 0 && col[y] == 0 && diagonal[i][y] == 0)
			{
				board[i][y] = 'Q';
				Marking(row, col, diagonal, i, y, n, 1);
				findNextOne(res, board, row, col, diagonal, i + 1, 0, n);
				Marking(row, col, diagonal, i, y, n, -1);
				board[i][y] = '.';
			}
		}
	}

	static void Marking(vector<int> &row, vector<int> &col, vector<vector<int> > &diagonal, int i, int j, int n, int mark) {

		row[i] += mark;
		col[j] += mark;

		for (int x = i, y = j; x >= 0 && y < n; x--, y++)
		{
			diagonal[x][y] += mark;
		}

		for (int x = i + 1, y = j - 1; x < n && y >= 0; x++, y--)
		{
			diagonal[x][y] += mark;
		}

		for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--)
		{
			diagonal[x][y] += mark;
		}

		for (int x = i + 1, y = j + 1; x < n && y < n; x++, y++)
		{
			diagonal[x][y] += mark;
		}
	}

};

int main() {
	LeetCode0051 leetCode0051;
	vector<vector<string> > ret = leetCode0051.solveNQueens(4);

	for (int i = 0; i < ret.size(); i++) {
		for (int j = 0; j < ret[0].size(); j++) {
			cout << ret[i][j] << endl;
		}
		cout << "----" << endl;
	}
	return 0;
}
