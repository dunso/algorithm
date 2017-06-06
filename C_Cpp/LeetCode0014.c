#include<stdio.h>

char* longestCommonPrefix(char** strs, int strsSize) {

	int str0_length = strsSize == 0 ? 0 : strlen(strs[0]);

	int i = 0, is_find = 0;
	for (; i < str0_length && !is_find; i++)
	{
		for (int j = 1; j < strsSize && !is_find; j++)
		{
			if (strs[0][i] != strs[j][i])
			{
				i--; is_find = 1;
			}
		}
	}

	char *result = (char*)malloc((i + 1) * sizeof(char));
	strncpy(result, strs[0], i);
	result[i] = '\0';
	return result;
}

//int main()
//{
//	char *strs[] = { "a","b" };
//	puts(longestCommonPrefix(strs, 2));
//	system("pause");
//	return 0;
//}