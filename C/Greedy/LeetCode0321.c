#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <stdio.h>

int* maxNumberSingleArray(int *nums, int k, int n) {
	int j = 0;
	int *ret = (int*)malloc(sizeof(int)*k);
	memset(ret, 0, sizeof(int)*k);
	for (int i = 0; i<n; ++i) {
		while (n - i + j>k &&  j>0 && nums[i]>ret[j - 1]) {
			j--;
		}
		if (j<k) {
			ret[j++] = nums[i];
		}
	}
	return ret;
}
bool greaterArray(int *nums1, int i, int sz1, int *nums2, int j, int sz2) {
	while (i<sz1 && j<sz2 && nums1[i] == nums2[j]) {
		i++;
		j++;
	}
	if (j == sz2 || (i<sz1 && nums1[i]>nums2[j])) {
		return true;
	}
	return false;
}
int* mergeTwoArrays(int *nums1, int sz1, int *nums2, int sz2, int k) {
	int *ret = (int*)malloc(sizeof(int)*k);
	int idx1 = 0;
	int idx2 = 0;
	int ridx = 0;
	while (ridx<k) {
		if (greaterArray(nums1, idx1, sz1, nums2, idx2, sz2)) {
			ret[ridx++] = nums1[idx1++];
		}
		else {
			ret[ridx++] = nums2[idx2++];
		}
	}
	return ret;
}
void print_array(int *nums, int sz) {
	for (int i = 0; i<sz; i++) {
		printf("%d ", nums[i]);
	}
	printf("\n");
}
#define max(x,y)(x>y?x:y)
int* maxNumber(int* nums1, int nums1Size, int* nums2, int nums2Size, int k, int* returnSize) {
	int *ret = NULL;
	for (int i = max(0, k - nums2Size); i <= k && i <= nums1Size; i++) {
		int *a1 = maxNumberSingleArray(nums1, i, nums1Size);
		int *a2 = maxNumberSingleArray(nums2, k - i, nums2Size);
		int *mergeCandidate = mergeTwoArrays(a1, i, a2, k - i, k); /* Guaranteed that size is k */
		if (!ret || greaterArray(mergeCandidate, 0, k, ret, 0, k)) {
			ret = mergeCandidate;
		}
		else {
			free(mergeCandidate);
		}
	}
	*returnSize = k;
	return ret;
}

int main()
{
	int returnSize = 0;
	int nums1[] = { 3, 4, 6, 5 };
	int nums2[] = { 9, 1, 2, 5, 8, 3 };
	maxNumber(nums1, 4, nums2, 6, 5, &returnSize);

}
