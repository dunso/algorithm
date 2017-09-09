#include <stdio.h>
#include <stdlib.h>

static int compare(const void* a, const void* b)
{
    return *(int*)a - *(int*)b;
}

int** threeSum(int* nums, int numsSize, int* returnSize)
{
    qsort(nums, numsSize, sizeof(int), compare);

    int** result = malloc(numsSize * numsSize * sizeof(int*) / 2);

    int target, head, tail;
    *returnSize = 0;

    for (int i = 0; i < numsSize - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }

        target = -nums[i];
        head = i + 1;
        tail = numsSize - 1;

        while (head < tail) {
            while (head < tail && nums[head] + nums[tail] < target)
                head++;
            while (head < tail && nums[head] + nums[tail] > target)
                tail--;

            if (head >= tail || nums[head] + nums[tail] != target) {
                continue;
            }

            result[*returnSize] = (int*)malloc(3 * sizeof(int));
            result[*returnSize][0] = nums[i];
            result[*returnSize][1] = nums[head];
            result[(*returnSize)++][2] = nums[tail];

            while (head < tail && nums[head] == nums[head + 1])
                head++;
            while (head < tail && nums[tail] == nums[tail - 1])
                tail--;

            head++;
            tail--;
        }
    }
    return result;
}

int main()
{
    int arr[] = { -2, 0, 0, 2, 2 };
    int** res = NULL;
    int size;

    res = threeSum(arr, 5, &size);

    for (int i = 0; i < size; i++) {
        printf("(%d, %d, %d)\n", res[i][0], res[i][1], res[i][2]);
    }

    for (int i = 0; i < size; i++) {
        free(res[i]);
    }
    free(res);
    return 0;
}