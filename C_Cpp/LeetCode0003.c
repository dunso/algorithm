#include <stdio.h>

int lengthOfLongestSubstring(char* s)
{
    int mAscii[256] = { 0 }, mResultLength = 0, i = 0;
    char* mResult = s;

    while (s[i] != '\0') {
        if (!mAscii[s[i]]) {
            mAscii[s[i++]]++;
            continue;
        }
        if (mResultLength < i) {
            mResult = s;
            mResultLength = i;
        }
        while (s[0] != s[i]) {
            mAscii[s[0]]--;
            s++;
            i--;
        }
        s++;
    }
    if (s[i] == '\0' && mResultLength < i) {
        mResult = s;
        mResultLength = i;
    }

    for (int i = 0; i < mResultLength; i++) {
        printf("%c ", mResult[i]);
    }
    printf("\n%d\n", mResultLength);

    return mResultLength;
}

int main()
{
    char s[9] = { 'a', 'b', 'c', 'a', 'b', 'c', 'b', 'b', '\0' };
    lengthOfLongestSubstring(s);
    return 0;
}