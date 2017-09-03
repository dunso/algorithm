#include <stdbool.h>
#include <stdio.h>

bool isPalindrome(int x)
{

    if (x < 0) {
        return false;
    }

    int mDigits = 1;

    for (int num = x; (num /= 10) > 0; mDigits *= 10)
        ;

    for (; mDigits != 0 && x / mDigits == x % 10; x %= mDigits, mDigits /= 100, x /= 10)
        ;

    return x == 0;
}

int main()
{
    int x = -1;
    printf("%d\n", isPalindrome(x));
    return 0;
}