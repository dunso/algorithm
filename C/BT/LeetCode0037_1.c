#include<stdio.h>
#include<stdbool.h>

bool isValid(char** board, int row, int colum, char num)
{
	int subCubeStartRow = 3 * (row / 3), subCubeStartColum = 3 * (colum / 3);
	for (int i = 0; i < 9; i++) {
		if (board[row][i] == num || board[i][colum] == num)
		{
			return false;
		}
		if (board[subCubeStartRow + i / 3][subCubeStartColum + i % 3] == num) return false;
	}
	return true;
}

bool solver(char** board, int row, int column)
{
	if (row == 9) return true;
	if (board[row][column] != '.') return solver(board, column + 1 == 9 ? row + 1 : row, (column + 1) % 9);
	for (char a = '1'; a <= '9'; a++)
	{
		if (isValid(board, row, column, a))
		{
			board[row][column] = a;
			if (solver(board, column + 1 == 9 ? row + 1 : row, (column + 1) % 9)) return true;
			board[row][column] = '.';
		}
	}
	return false;
}
void solveSudoku(char** board, int rSize, int cSize)
{
	solver(board, 0, 0);
}