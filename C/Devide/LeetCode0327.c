#include <stdint.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int countRangeSumByMerge(int32_t *sums, int l, int r, int lower, int upper)
{
	if (l > r)
	{
		return 0;
	}

	if(l == r)
	{
		return sums[l] >= lower && sums[r] <= upper ? 1 : 0;
	}

	int m = l + (r - l >> 1);
	   
	int count = countRangeSumByMerge(sums, l, m, lower, upper) + countRangeSumByMerge(sums, m + 1, r, lower, upper);

	int32_t * mergedArray = (int32_t *)malloc(sizeof(int32_t) * r - l + 1);
	memset(mergedArray, 0, sizeof(int32_t)*(r - l + 1));
	int  x = 0, y = m + 1;
	for (int i = l, j = m + 1, k = m + 1; i <= m;)
	{
		while (j <= r && sums[j] - sums[i] < lower) j++;
		while (k <= r && sums[k] - sums[i] <= upper) k++;
		count += k - j;

		while (y <= r && sums[y] < sums[i]) mergedArray[x++] = sums[y++];
		mergedArray[x++] = sums[i++];
	}

	while (y <= r) mergedArray[x++] = sums[y++];

	for(int i = 0; i< x; i++)
	{
		sums[l++] = mergedArray[i++];
	}

	return count;
}

int countRangeSum(int* nums, int numsSize, int lower, int upper) {

	if(nums == NULL || numsSize == 0 || lower > upper)
	{
		return 0;
	}

	int32_t *sums = (int32_t *)malloc(sizeof(int32_t) * numsSize + 1);
	memset(sums, 0, sizeof(int32_t)*(numsSize + 1));

	for (int i = 0; i< numsSize; i++) {
		sums[i + 1] = sums[i] + nums[i];
	}
	return countRangeSumByMerge(sums, 1, numsSize, lower, upper);
}


int main()
{
	int32_t nums[] = {0, -3, -3, 1, 1, 2};
	printf("%d", countRangeSum(nums, 6, 3, 5));
	system("pause");
	return 0;
}
