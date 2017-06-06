#include<stdio.h>
#include<math.h>

int FindKthMin(int* aNums1, int aNums1Size, int * aNums2, int aNums2Size, int aK)
{
	if (aNums1Size > aNums2Size)
	{
		return FindKthMin(aNums2, aNums2Size, aNums1, aNums1Size, aK);
	}
	if (!aNums1Size)
	{
		return aNums2[aK - 1];
	}
	if (aK == 1)
	{
		return fmin(aNums1[0], aNums2[0]);
	}

	int mI = (aNums1Size + 1) >> 1, mJ = aK - mI;

	if (aNums1[mI - 1] > aNums2[mJ - 1])
	{
		return FindKthMin(aNums1, mI, aNums2 + mJ, aNums2Size - mJ, mI);
	}
	else
	{
		return FindKthMin(aNums1 + mI, aNums1Size - mI, aNums2, mJ, mJ);
	}
}

double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size)
{
	int mLeftIndex = (nums1Size + nums2Size + 1) >> 1;
	int mRightIndex = (nums1Size + nums2Size + 2) >> 1;

	if ((nums1Size + nums2Size) & 1)
	{
		return FindKthMin(nums1, nums1Size, nums2, nums2Size, mLeftIndex);
	}
	return (FindKthMin(nums1, nums1Size, nums2, nums2Size, mLeftIndex)
		+ FindKthMin(nums1, nums1Size, nums2, nums2Size, mRightIndex)) / 2.0;
}

//int main()
//{
//	int mNums1[] = { 1, 2 };
//	int mNums2[] = { 1, 1 };
//	double mResult = findMedianSortedArrays(mNums1, 2, mNums2, 2);
//	printf("%lf\n", mResult);
//	system("pause");
//	return 0;
//}