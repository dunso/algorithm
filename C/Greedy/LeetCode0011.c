#include <stdio.h>

int maxArea(int* height, int heightSize)
{
    int mContain = 0;
    for (int *i = height, *j = height + heightSize - 1; i < j;) {
        int mMinHeight = *i < *j ? *i : *j;
        int mTmpContain = (j - i) * mMinHeight;
        mContain = mContain < mTmpContain ? mTmpContain : mContain;
        while (i < j && *i <= mMinHeight)
            i++;
        while (i < j && *j <= mMinHeight)
            j--;
    }
    return mContain;
}

int main()
{
    int height[] = { 1, 1 };
    printf("%d\n", maxArea(height, 2));
    return 0;
}