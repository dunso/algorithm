#include <stdio.h>
#include <stdlib.h>

int* row;
int* col;
int** diagonal;
char ** board;

void Marking(int i, int j, int n, int mark) {
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

	for (int x = i - 1, y = j - 1; x >= 0 && y >=0; x--, y--)
	{
		diagonal[x][y] += mark;
	}

	for (int x = i + 1, y = j + 1; x < n && y < n; x++, y++ )
	{
		diagonal[x][y] += mark;
	}
}


void findNextOne(char*** ret, int * returnSize, int i, int j, int n, int queenNum)
{
	if(queenNum == n)
	{

		if(queenNum == 3)
		{
			int vd = 1;
		}
		ret[*returnSize] = (char **)malloc(sizeof(char *) * n);

		for (int a = 0; a< n; a++)
		{
			ret[*returnSize][a] = (char *)malloc(sizeof(char) * (n + 1));
		}

		for(int a = 0; a < n; a++)
		{
			for(int b = 0; b < n; b++)
			{
				ret[*returnSize][a][b] = board[a][b];
				printf("%c ", board[a][b]);
			}
			ret[*returnSize][a][n] = '\0';
			printf("\n");
		}

		(*returnSize) ++;

		return;
	}

	for(int y = j; y < n; y++)
	{
		if(row[i] == 0 && col[y]==0 && diagonal[i][y]==0)
		{
			board[i][y] = 'Q';
			Marking(i, y, n, 1);
			queenNum++;
			findNextOne(ret, returnSize, i + 1, 0, n, queenNum);
			Marking(i, y, n, -1);
			board[i][y] = '.';
			queenNum--;
		}
	}
}

char*** solveNQueens(int n, int* returnSize) {

	board = (char **)malloc(sizeof(char*) * n);
	for(int i = 0; i< n; i++)
	{
		board[i] = (char *)malloc(sizeof(char) * n);
	}

	row = (int *)malloc(sizeof(int) * n);
	col = (int *)malloc(sizeof(int) * n);

	diagonal = (int **)malloc(sizeof(int) * n);
	for(int i = 0; i< n; i++)
	{
		diagonal[i] = (int *)malloc(sizeof(char) * n);
	}

	for (int i = 0; i < n; i++)
	{
		row[i] = 0; col[i] = 0;
		for(int j = 0; j< n; j++)
		{
			board[i][j] = '.';
			diagonal[i][j] = 0;
		}
	}

	*returnSize = 0;
	char*** ret = (char***)malloc(sizeof(char **) * 1024);

	findNextOne(ret,returnSize, 0, 0, n, 0);

	return ret;
}

int main()
{
	int n = 4;
	int returnSize;
	solveNQueens(n, &returnSize);
	system("pause");
	return 0;
}
