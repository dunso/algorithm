#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>


#define MASK 0x01FF

typedef struct record {
    int row, col, block;
} record;

typedef struct bitMark {
    int row, col, block;
} bitMark;

record rec[81];
bitMark marks[9];
int num = 0;

int findNextToBeHandledPoint(int index)
{
    int min = INT_MAX, tobeHandle = index;
    for (int i = index; i < num; i++) {
        int possible = marks[rec[i].row].row & marks[rec[i].col].col & marks[rec[i].block].block;
        int bitCount = 0;
        for (; possible; possible &= possible - 1, bitCount++)
            ;
        if (bitCount < min) {
            min = bitCount;
            tobeHandle = i;
        }
    }
    return tobeHandle;
}

bool solve(char** board, int index)
{
    if (index >= num) {
        return true;
    }
    int tobeHandle = findNextToBeHandledPoint(index);

    record tmp = rec[tobeHandle];
    rec[tobeHandle] = rec[index];
    rec[index] = tmp;

    int possible = marks[rec[index].row].row & marks[rec[index].col].col & marks[rec[index].block].block;
    while (possible) {
        int valbit = possible & -possible;
        int reverseValbit = ~valbit;

        possible &= reverseValbit;
        marks[rec[index].row].row &= reverseValbit;
        marks[rec[index].col].col &= reverseValbit;
        marks[rec[index].block].block &= reverseValbit;

        board[rec[index].row][rec[index].col] = log2(valbit) + '1';

        if (solve(board, index + 1)) {
            return true;
        }
        marks[rec[index].row].row |= valbit;
        marks[rec[index].col].col |= valbit;
        marks[rec[index].block].block |= valbit;
    }

    board[rec[index].row][rec[index].col] = '.';
    return false;
}

void solveSudoku(char** board, int m, int n)
{
    for (int i = 0; i < 9; i++) {
        marks[i].row = MASK;
        marks[i].col = MASK;
        marks[i].block = MASK;
    }
    num = 0;
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
                rec[num].row = i;
                rec[num].col = j;
                rec[num++].block = i / 3 * 3 + j / 3;
            } else {
                int mark = ~(1 << board[i][j] - '1');
                marks[i].row &= mark;
                marks[j].col &= mark;
                marks[i / 3 * 3 + j / 3].block &= mark;
            }
        }
    }
    solve(board, 0);
}

int main()
{
    char board[][9] = {
        { "53..7...." },
        { "6..195..." },
        { ".98....6." },
        { "8...6...3" },
        { "4..8.3..1" },
        { "7...2...6" },
        { ".6....28." },
        { "...419..5" },
        { "....8..79" }
    };
    solveSudoku(board, 9, 9);
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            printf("%c", board[i][j]);
        }
        printf("\n");
    }
    system("pause");
    return 0;
}
