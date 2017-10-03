#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char* removeDuplicateLetters(char* s)
{

    int remain_count[128];
    int result_has[128];

    for (int i = 97; i < 128; i++) {
        remain_count[i] = 0;
        result_has[i] = 0;
    }

    int length = strlen(s);

    for (int i = 0; i < length; i++) {
        remain_count[s[i]]++;
    }

    char* stack = malloc(sizeof(char) * length);

    int top = 0;

    for (int i = 0; i < length; i++) {
        while (top > 0) {
            if (stack[top - 1] < s[i] || remain_count[stack[top - 1]] == 0 || result_has[s[i]]) {
                break;
            }
            result_has[stack[top - 1]]--;
            top--;
        }

        if (!result_has[s[i]]) {
            stack[top++] = s[i];
            result_has[s[i]]++;
        }

        remain_count[s[i]]--;
    }

    stack[top] = '\0';
    return stack;
}

int main()
{
    char* s = "abacb\0";
    char* result = removeDuplicateLetters(s);
    puts(result);
    system("pause");
    return 0;
}