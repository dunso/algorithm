#include <stdio.h>
#include <stdlib.h>

struct ListNode
{
	int val;
	struct ListNode * next;
};

void swap(struct ListNode ** node1, struct ListNode ** node2)
{
	struct ListNode * tmp = *node1; *node1 = *node2; *node2 = tmp;
}

struct ListNode * adjustHeap(struct ListNode ** nums, int numsSize, int i)
{
	while (i < numsSize >> 1)
	{
		int child = (i << 1) + 2 < numsSize ? nums[(i << 1) + 1]->val > nums[(i << 1) + 2]->val ? (i << 1) + 2 : (i << 1) + 1 : (i << 1) + 1;

		if (nums[i]->val <= nums[child]->val)
		{
			return nums[0];
		}
		swap(&nums[i], &nums[child]); i = child;
	}
	return nums[0];
}

void createHeap(struct ListNode ** nums, int numsSize)
{
	for (int i = (numsSize >> 1) - 1; i >= 0; i--)
	{
		adjustHeap(nums, numsSize, i);
	}
}

struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {

	struct ListNode ** heap = malloc(listsSize * sizeof(struct ListNode));

	int count = 0;

	for (int i = 0; i< listsSize; i++)
	{
		if (lists[i] != NULL)
		{
			heap[count++] = lists[i];
		}
	}

	if (count == 0)
	{
		return NULL;
	}

	createHeap(heap, count);

	struct ListNode * result = heap[0];
	struct ListNode * current = result;

	while (current != NULL)
	{
		if (current->next != NULL || count == 1)
		{
			heap[0] = current->next;
		}
		else if (count > 1)
		{
			heap[0] = heap[--count];
		}

		adjustHeap(heap, count, 0);
		current->next = heap[0];
		current = current->next;
	}

	return result;
}

int main()
{
	struct ListNode * ln11 = (struct ListNode *)malloc(sizeof(struct ListNode));
	ln11->val = 1;
	struct ListNode * ln12 = (struct ListNode *)malloc(sizeof(struct ListNode));
	ln12->val = 2;
	struct ListNode * ln13 = (struct ListNode *)malloc(sizeof(struct ListNode));
	ln13->val = 2;
	ln11->next = ln12;
	ln12->next = ln13;
	ln13->next = NULL;

	struct ListNode * ln21 = (struct ListNode *)malloc(sizeof(struct ListNode));
	ln21->val = 1;
	struct ListNode * ln22 = (struct ListNode *)malloc(sizeof(struct ListNode));
	ln22->val = 1;
	struct ListNode * ln23 = (struct ListNode *)malloc(sizeof(struct ListNode));
	ln23->val = 2;
	ln21->next = ln22;
	ln22->next = ln23;
	ln23->next = NULL;

	struct ListNode * lists[] = { ln11,ln21 };

	struct ListNode * result = mergeKLists(lists, 2);

	while (result != NULL)
	{
		printf("%d", result->val);
		result = result->next;
	}
	printf("\n");
	system("pause");
	return 0;
}