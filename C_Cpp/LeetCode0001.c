#include <stdio.h>

void QuickSort(int* aNums, int* aIndex, int aHead, int aTail)
{
    if (aHead >= aTail) {
        return;
    }
    int mLeft = aHead, mRight = aTail, mNumTmp = aNums[mLeft], mIndexTmp = aIndex[mLeft];

    while (mLeft < mRight) {
        while (mLeft < mRight && aNums[mRight] >= mNumTmp)
            mRight--;
        if (mLeft < mRight) {
            aNums[mLeft] = aNums[mRight];
            aIndex[mLeft] = aIndex[mRight];
            mLeft++;
        }
        while (mLeft < mRight && aNums[mLeft] < mNumTmp)
            mLeft++;
        if (mLeft < mRight) {
            aNums[mRight] = aNums[mLeft];
            aIndex[mRight] = aIndex[mLeft];
            mRight--;
        }
    }
    aNums[mLeft] = mNumTmp;
    aIndex[mLeft] = mIndexTmp;

    QuickSort(aNums, aIndex, aHead, mLeft - 1);
    QuickSort(aNums, aIndex, mLeft + 1, aTail);
}

int* twoSum(int* nums, int numsSize, int target)
{
    if (numsSize < 2) {
        return NULL;
    }

    int* mIndex = (int*)malloc(numsSize * sizeof(int));

    for (int i = 0; i < numsSize; i++) {
        mIndex[i] = i;
    }

    QuickSort(nums, mIndex, 0, numsSize - 1);

    int mLeft = 0, mRight = numsSize - 1;

    if (mLeft == mRight) {
        return NULL;
    }

    int mNum = nums[mLeft] + nums[mRight];

    while (mNum != target) {
        if (mNum > target && --mRight > mLeft) {
        } else if (mNum < target && ++mLeft < mRight) {
        }
        if (mLeft == mRight) {
            return NULL;
        }
        mNum = nums[mLeft] + nums[mRight];
    }

    if (mNum == target) {
        int* mResult = malloc(2 * sizeof(int));
        mResult[0] = mIndex[mLeft];
        mResult[1] = mIndex[mRight];
        return mResult;
    }
    return NULL;
}

//int main()
//{
//	int mNums[4] = { -3,4,3,90 };
//
//	int* mResult = twoSum(mNums, 4, 0);
//
//	printf("[%d,%d]", mResult[0], mResult[1]);
//
//	system("pause");
//
//	return 1;
//}