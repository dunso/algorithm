#include<stdio.h>
#include<limits.h>

int myAtoi(char * str)
{
	long long mResult = 0;

	while (isspace(*str++));

	int mSign = *--str == '-' ? -1 : *str == '+' ? 1 : 0;

	for (str = mSign ? ++str : str; isdigit(*str) && mResult <= INT_MAX; str++)
	{
		mResult = mResult * 10 + (*str - 48);
	}
	return mResult > INT_MAX ? mSign == -1 ? INT_MIN : INT_MAX : mSign == -1 ? -mResult : mResult;
}

int main()
{
	char input[] = { '-','2','1','4','7','4','8','3','6','4','7','\0' };
	printf("%ld\n", myAtoi(input));
	system("pause");
	return 0;
}