#include <stdio.h>
#include <limits.h>
#include <stdlib.h>

static int compare(const void* a, const void *b) {
	return *(int*)a - *(int*)b;
}

int threeSumClosest(int* nums, int numsSize, int target) {

	qsort(nums, numsSize, sizeof(int), compare);

	int result = 0, min = INT_MAX;

	for (int i = 0; i < numsSize - 2; i++)
	{
		if (i > 0 && nums[i] == nums[i - 1])
		{
			continue;
		}

		int head = i + 1, tail = numsSize - 1;

		while (head < tail)
		{
			int tmp = nums[head] + nums[tail] + nums[i];

			if (min > abs(tmp - target)) {
				min = abs(tmp - target);
				result = tmp;
			}

			if (tmp > target) {
				tail--;
			}
			else if (tmp < target) {
				head++;
			}
			else {
				return tmp;
			}
		}
	}
	return result;
}

//int main()
//{
//	int arr[] = { 1,1,1,0 };
//	printf("%d\n", threeSumClosest(arr, 4, -100));
//	system("pause");
//	return 0;
//}