#include <stdio.h>
#include <string.h>

char* longestPalindrome(char* s)
{
    int mLength = strlen(s);

    int mMaxLength = 0;
    int mPalindromeStart = 0;
    int mPalindromeEnd = 0;

    for (int i = 0; i < mLength - 1; i++) {
        int mStart = i, mEnd = i + 1;
        for (; mStart >= 0 && mEnd < mLength; mStart--, mEnd++) {
            if (s[mStart] != s[mEnd]) {
                break;
            }
        }
        if (mMaxLength < mEnd - 1 - (mStart + 1) + 1) {
            mMaxLength = mEnd - 1 - (mStart + 1) + 1;
            mPalindromeStart = mStart + 1;
            mPalindromeEnd = mEnd - 1;
        }

        mStart = i - 1, mEnd = i + 1;
        for (; mStart >= 0 && mEnd < mLength; mStart--, mEnd++) {
            if (s[mStart] != s[mEnd]) {
                break;
            }
        }

        if (mMaxLength < mEnd - 1 - (mStart + 1) + 1) {
            mMaxLength = mEnd - 1 - (mStart + 1) + 1;
            mPalindromeStart = mStart + 1;
            mPalindromeEnd = mEnd - 1;
        }
    }
    s[mPalindromeEnd + 1] = '\0';
    s += mPalindromeStart;
    return s;
}

int main()
{
    char s[] = "cbbd";
    char* result = longestPalindrome(s);
    puts(result);
    return 0;
}