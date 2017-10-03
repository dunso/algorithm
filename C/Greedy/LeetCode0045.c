#include <stdio.h>
#include <stdlib.h>

#define MAX(a, b) (((a) > (b)) ? (a) : (b))

int jump(int* nums, int numsSize)
{

    int curFurthest = 0, curEnd = 0, jump = 0;

    for (int i = 0; i < numsSize - 1; i++) {

        curFurthest = MAX(nums[i] + i, curFurthest);

        if (curFurthest >= numsSize - 1) {
            jump++;
            break;
        }
        if (i == curEnd) {
            jump++;
            curEnd = curFurthest;
        }
    }
    return jump;
}

int main()
{
    int nums[] = { 2, 3, 1, 1, 4 };
    printf("%d\n", jump1(nums, 5));
    system("pause");
    return 0;
}