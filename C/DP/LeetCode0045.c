#include <stdio.h>
#include <stdlib.h>

int jump(int* nums, int numsSize)
{

    int* dp = malloc(sizeof(int) * numsSize);

    for (int i = 1; i < numsSize; i++) {
        dp[i] = numsSize + 1;
    }

    dp[0] = 0;

    for (int i = 0; i < numsSize; i++) {
        if (dp[i] < 0)
            continue;

        for (int j = 1; j <= nums[i] && i + j < numsSize; j++) {
            if (i + j < numsSize - 1 && nums[i] - j >= nums[i + j]) {
                dp[i + j] = -1;
            } else if (dp[i + j] > dp[i] + 1) {
                dp[i + j] = dp[i] + 1;
            }
        }
    }

    return dp[numsSize - 1];
}

int main()
{
    int nums[] = { 2, 3, 1, 1, 4 };
    printf("%d\n", jump(nums, 5));
    system("pause");
    return 0;
}