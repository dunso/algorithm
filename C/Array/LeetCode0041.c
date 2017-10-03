#include<stdio.h>

int firstMissingPositive(int * nums, int numsSize)
{
	for(int i = 0; i< numsSize; i++)
	{
		if(nums[i] <= 0 || nums[i] > numsSize || nums[i] == i + 1)
		{
			continue;
		}

		if(nums[nums[i] - 1] != nums[i])
		{
			int tmp = nums[nums[i] - 1];
			nums[nums[i] - 1] = nums[i];
			nums[i] = tmp;
			i--;
		}
	}

	for(int i = 0; i< numsSize; i++)
	{
		if(nums[i] != i +1)
		{
			return i + 1;
		}
	}
	return numsSize + 1;
}

int main()
{
	int nums[] = { 3, 4, -1, 1 };
	printf("%d", firstMissingPositive(nums, 4));
	system("pause");
	return 0;
}
