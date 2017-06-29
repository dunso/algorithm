#include <stdio.h>
#include <stdlib.h>

char ** board;
int* row;
int* col;
int** diagonal;

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

	for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--)
	{
		diagonal[x][y] += mark;
	}

	for (int x = i + 1, y = j + 1; x < n && y < n; x++, y++)
	{
		diagonal[x][y] += mark;
	}
}

void findNextOne(char*** ret, int* returnSize, int i, int j, int n)
{
	if (i == n)
	{
		ret[*returnSize] = (char **)malloc(sizeof(void *) * n);

		for (int a = 0; a < n; a++)
		{
			ret[*returnSize][a] = (char *)malloc(sizeof(char) * (n + 1));
		}

		for (int a = 0; a < n; a++)
		{
			for (int b = 0; b < n; b++)
			{
				ret[*returnSize][a][b] = board[a][b];
			}
			ret[*returnSize][a][n] = '\0';
		}

		(*returnSize)++;

		return;
	}

	for (int y = j; y < n; y++)
	{
		if (row[i] == 0 && col[y] == 0 && diagonal[i][y] == 0)
		{
			board[i][y] = 'Q';
			Marking(i, y, n, 1);
			findNextOne(ret, returnSize, i + 1, 0, n);
			Marking(i, y, n, -1);
			board[i][y] = '.';
		}
	}
}

char*** solveNQueens(int n, int* returnSize) {

	*returnSize = 0;
	char*** ret = (char***)malloc(sizeof(char **) * 512);

	board = (char **)malloc(sizeof(char*) * n);
	for (int i = 0; i< n; i++)
	{
		board[i] = (char *)malloc(sizeof(char) * n);
	}

	row = (int *)malloc(sizeof(int) * n);
	col = (int *)malloc(sizeof(int) * n);
	diagonal = (int **)malloc(sizeof(int *) * n);

	for (int i = 0; i< n; i++)
	{
		diagonal[i] = (int *)malloc(sizeof(int) * n);
	}

	for (int i = 0; i < n; i++)
	{
		row[i] = 0; col[i] = 0;
		for (int j = 0; j< n; j++)
		{
			board[i][j] = '.';
			diagonal[i][j] = 0;
		}
	}

	findNextOne(ret, returnSize, 0, 0, n);
	return ret;
}

int main()
{
	int n = 8;
	int returnSize = 0;
	char*** res = solveNQueens(n, &returnSize);
	printf("size = %d\n", returnSize);

	for (int i = 0; i < returnSize; i++)
	{
		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++)
			{
				printf("%c ", res[i][j][k]);
			}
			printf("\n");
			free(res[i][j]);
		}
		printf("\n");
		free(res[i]);
	}

	free(res);
	system("pause");
	return 0;
}
