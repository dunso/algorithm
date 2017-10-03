#include <stdio.h>
#include <stdlib.h>

char** board;
int* row;
int* col;
int** diagonal;

void label(int i, int j, int n, int mark)
{
    row[i] += mark;
    col[j] += mark;

    for (int x = i, y = j; x >= 0 && y < n; x--, y++) {
        diagonal[x][y] += mark;
    }

    for (int x = i + 1, y = j - 1; x < n && y >= 0; x++, y--) {
        diagonal[x][y] += mark;
    }

    for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
        diagonal[x][y] += mark;
    }

    for (int x = i + 1, y = j + 1; x < n && y < n; x++, y++) {
        diagonal[x][y] += mark;
    }
}

void palce(int* returnSize, int i, int j, int n)
{
    if (i == n) {
        (*returnSize)++;
        return;
    }

    for (int y = j; y < n; y++) {
        if (row[i] == 0 && col[y] == 0 && diagonal[i][y] == 0) {
            board[i][y] = 'Q';
            label(i, y, n, 1);
            palce(returnSize, i + 1, 0, n);
            label(i, y, n, -1);
            board[i][y] = '.';
        }
    }
}

int totalNQueens(int n)
{

    board = (char**)malloc(sizeof(char*) * n);
    for (int i = 0; i < n; i++) {
        board[i] = (char*)malloc(sizeof(char) * n);
    }

    row = (int*)malloc(sizeof(int) * n);
    col = (int*)malloc(sizeof(int) * n);

    diagonal = (int**)malloc(sizeof(int*) * n);
    for (int i = 0; i < n; i++) {
        diagonal[i] = (int*)malloc(sizeof(int) * n);
    }

    for (int i = 0; i < n; i++) {
        row[i] = 0;
        col[i] = 0;
        for (int j = 0; j < n; j++) {
            board[i][j] = '.';
            diagonal[i][j] = 0;
        }
    }

    int returnSize = 0;
    palce(&returnSize, 0, 0, n);
    return returnSize;
}

int main()
{
    int n = 8;
    printf("size = %d\n", totalNQueens(n));
    system("pause");
    return 0;
}