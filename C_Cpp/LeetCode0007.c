#include <limits.h>
#include <stdio.h>

int reverse(int x)
{
    long long mResult = 0;
    while (x) {
        mResult = mResult * 10 + x % 10;

        if (mResult > INT_MAX || mResult < INT_MIN) {
            return 0;
        }
        x /= 10;
    }
    return mResult;
}

int main()
{
    printf("%d\n", reverse(1534236469));
    return 0;
}