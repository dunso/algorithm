#include<stdio.h>
#include<stdlib.h>

struct ListNode
{
	int val;
	struct ListNode *next;
};

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2)
{
	struct ListNode* mPreNode = l1;
	struct ListNode* mHead = l1;
	int mCarry = 0, mSum = 0;

	while (l1 != NULL && (l2 != NULL || mCarry != 0))
	{
		mSum = l1->val + (l2 ? l2->val : 0) + mCarry;
		l1->val = mSum % 10;
		mCarry = mSum / 10;

		mPreNode = l1;
		l1 = l1 ? l1->next : NULL;
		l2 = l2 ? l2->next : NULL;
	}

	if (l1 == NULL && l2 != NULL) {
		mPreNode->next = l2;
		l1 = l2;
	}

	while (mCarry != 0) {
		if (l1 == NULL) {
			l1 = (struct ListNode*)malloc(sizeof(struct ListNode));
			l1->next = NULL;
			l1->val = mCarry;
			mPreNode->next = l1;
			mCarry = 0;
		}
		else {
			mSum = l1->val + mCarry;
			l1->val = mSum % 10;
			mCarry = mSum / 10;
			mPreNode = l1;
			l1 = l1->next;
		}
	}

	return mHead;
}

struct ListNode* ArrayToLink(int aArray[], int aLength)
{
	struct ListNode* aHead = (struct ListNode*)malloc(sizeof(struct ListNode));
	struct ListNode* mPreNode = aHead;

	for (int i = 0; i < aLength; i++)
	{
		struct ListNode* mNode = (struct ListNode*)malloc(sizeof(struct ListNode));
		mNode->val = aArray[i];
		mPreNode->next = mNode;
		mPreNode = mNode;
	}
	mPreNode->next = NULL;

	return aHead;
}

int main()
{
	int mA1[] = { 1 }, mA2[] = { 9,9 };

	struct ListNode* mL1 = ArrayToLink(mA1, 1);
	struct ListNode* mL2 = ArrayToLink(mA2, 2);

	struct ListNode* mResult = addTwoNumbers(mL1->next, mL2->next);

	if (mResult != NULL)
	{
		printf("%d", mResult->val);
		mResult = mResult->next;
	}

	while (mResult != NULL)
	{
		printf(" -> %d", mResult->val);
		mResult = mResult->next;
	}

	return 1;
}