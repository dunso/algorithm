#include<stdio.h>

char* intToRoman(int num) {

	char* table[4][10] =
	{
		{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
		{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
		{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
		{ "", "M", "MM", "MMM" }
	};

	int m = num / 1000, c = num % 1000 / 100, x = num % 100 / 10, i = num % 10;

	char * result = (char *)malloc(strlen(table[3][m]) + strlen(table[2][c]) + strlen(table[1][x]) + strlen(table[0][i]) + 1);

	strcpy(result, table[3][m]);
	strcat(result, table[2][c]);
	strcat(result, table[1][x]);
	strcat(result, table[0][i]);

	return result;
}

int main() {
	printf("%s\n", intToRoman(3999));
	system("pause");
	return 0;
}