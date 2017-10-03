#include <limits.h>
#include <stdlib.h>
#include <stdio.h>

typedef struct segmentTree
{
	int min;
	int max;
	int count;
}segmentTree;

segmentTree* tree;
int min = INT_MAX;
void buildTree(int l, int r, int current)
{
	tree[current].min = l;
	tree[current].max = r;
	tree[current].count = 0;
	if(l == r)
	{
		return;
	}
	int mid = tree[current].min + tree[current].max >> 1;
	buildTree(l, mid, current << 1);
	buildTree(mid + 1, r, current << 1 | 1);
}

int query(int num, int current)
{
	if(num >= tree[current].max)
	{
		return tree[current].count;
	}
	if(num < min)
	{
		return 0;
	}
	
	if(num <=  tree[current].min + tree[current].max >> 1)
	{
		return query(num, current << 1);
	}
	
	return query(num, current << 1) + query(num, current << 1 | 1);

}

void insert(int num, int current)
{
	if(num < tree[current].min || num > tree[current].max || tree[current].min == tree[current].max)
	{
		return;
	}

	tree[current].count++;

	int mid = tree[current].min + tree[current].max >> 1;

	if(num <= mid)
	{
		insert(num, current << 1);
	}else
	{
		insert(num, current << 1 | 1);
	}
}

int* countSmaller(int* nums, int numsSize, int* returnSize) {

	(*returnSize) = 0;
	int * result = (int *)malloc(sizeof(int*) * numsSize);

	if(numsSize == 0)
	{
		return result;
	}

	int max = INT_MIN;
	min = INT_MAX;

	for(int i = 0; i< numsSize; i++)
	{
		min = min > nums[i] ? nums[i] : min;
		max = max < nums[i] ? nums[i] : max;
	}

	tree = (segmentTree*)malloc(sizeof(segmentTree) * (max - min + 1) * 4);

	buildTree(min, max, 1);

	for(int i = numsSize - 1; i >= 0; i--)
	{
		result[i] = query(nums[i] -1, 1);
		insert(nums[i], 1);
		(*returnSize)++;
	}
	return result;
}

int main()
{
	int nums[] = { 1,9,7,8,5 };

	int *returnSize = malloc(sizeof(int));
	int * result= countSmaller(nums, 5, returnSize);
	for(int i = 0; i< *returnSize; i++)
	{
		printf("%d ", result[i]);
	}
	system("pause");
	return 0;
}
