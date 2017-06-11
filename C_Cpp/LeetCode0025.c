#include<stdio.h>
#include <stdlib.h>

struct ListNode
{
	int val;
	struct ListNode * next;
};

struct ListNode * reverseKNode(struct ListNode * start, int k)
{
	struct ListNode * end = start->next;
	int i = k;
	while (i-- > 0 && end != NULL)
	{
		end = end->next;
	}

	if (i >= 0)
	{
		return end;
	}

	struct ListNode *current = start->next->next, *preNode = start->next;
	while (--k > 0)
	{
		struct ListNode *tmp = current->next;
		current->next = preNode;
		preNode = current;
		current = tmp;
	}
	end = start->next;
	end->next = current;
	start->next = preNode;

	return end;
}

struct ListNode * reverseKGroup(struct ListNode* head, int k)
{
	if (head == NULL || k == 1)
	{
		return head;
	}

	struct ListNode * dummy = (struct ListNode *) malloc(sizeof(struct ListNode));
	dummy->next = head;

	struct ListNode * start = dummy;
	while (start != NULL)
	{
		start = reverseKNode(start, k);
	}
	return dummy->next;
}

int main()
{
	struct ListNode * ln = (struct ListNode *) malloc(3 * sizeof(struct ListNode));
	ln->val = 1;
	(ln + 1)->val = 2;
	(ln + 2)->val = 3;
	ln->next = ln + 1;
	(ln + 1)->next = ln + 2;
	(ln + 2)->next = NULL;
	struct ListNode * result = reverseKGroup(ln, 3);

	while (result != NULL)
	{
		printf("%d", result->val);
		result = result->next;
	}

	system("pause");
	return 0;
}