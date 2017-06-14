#include<stdio.h>
#include <string.h>
#include <stdlib.h>

int longestValidParentheses(char* s) {

	int length = strlen(s);

	if (length <= 1)
	{
		return 0;
	}

	int result = 0;

	int* dp = (int *)malloc(length * sizeof(int));

	dp[0] = 0;

	for (int i = 1; i < length; i++)
	{
		if (s[i] == ')' && i - dp[i - 1] - 1 >= 0 && s[i - dp[i - 1] - 1] == '(')
		{
			dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
			result = dp[i] > result ? dp[i] : result;
		}
		else
		{
			dp[i] = 0;
		}
	}
	return result;
}

int main()
{
	char * s = ")()())";
	printf("%d\n", longestValidParentheses(s));
	system("pause");
	return 0;
}