#include <string.h>
#include <stdlib.h>
#include <stdio.h>

char* removeDuplicateLetters(char* s) {

	int remain_count[26];
	int result_has[26];

	for(int i = 0; i< 26; i++)
	{
		remain_count[i] = 0;
		result_has[i] = 0;
	}

	int length = strlen(s);

	for(int i = 0; i< length; i++)
	{
		remain_count[s[i] - 97] ++;
	}

	char* stack = malloc(sizeof(char)*length);

	int top = 0;

	for(int i = 0; i< length; i++)
	{
		while(top > 0)
		{
			if(stack[top -1] < s[i] || remain_count[stack[top - 1] - 97] == 0 || result_has[s[i] - 97])
			{
				break;
			}
			result_has[stack[top - 1] - 97] --;
			top--;
		}

		if(!result_has[s[i] - 97])
		{
			stack[top++] = s[i];
			result_has[s[i] - 97] ++;
		}

		remain_count[s[i] - 97] --;
	}

	stack[top] = '\0';
	return stack;
}

int main()
{
	char *s = "abacb\0";
	char * result = removeDuplicateLetters(s);
	puts(result);
	system("pause");
	return 0;
}
