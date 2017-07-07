/* Naive */
int countRangeSum2(int* nums, int numsSize, int lower, int upper) {
    long sums[numsSize+1];
    memset(sums, 0, sizeof(sums));
    int count=0;
    for(int i=0; i<numsSize; i++) {
        sums[i+1]=sums[i]+nums[i];
        printf("i=%d sum=%d\n", i, sums[i]);
    }
    for(int i=0; i<numsSize; i++) {
        for(int j=i+1; j<=numsSize; j++) {
            //printf("i=%d j=%d sum[i]=%d sum[j]=%d %d\n", i, j, sums[i], sums[j], sums[j]-sums[i]);
            if(sums[j]-sums[i]>=lower && sums[j]-sums[i]<=upper) {
                count++;
            }
        }
    }
    return count;
}

void merge(int64_t arr[], int l, int m, int r)
{
    int i, j, k;
    int n1 = m - l + 1;
    int n2 =  r - m; 
 
    int64_t L[n1], R[n2];
 
    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1+ j];

    
    /* Merge the temp arrays back into arr[l..r]*/
    i = 0; // Initial index of first subarray
    j = 0; // Initial index of second subarray
    k = l; // Initial index of merged subarray
    while (i < n1 && j < n2)
    {
        if (L[i] <= R[j])
        {
            arr[k] = L[i];
            i++;
        }
        else
        {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
 
    /* Copy the remaining elements of L[], if there
       are any */
    while (i < n1)
    {
        arr[k] = L[i];
        i++;
        k++;
    }
 
    /* Copy the remaining elements of R[], if there
       are any */
    while (j < n2)
    {
        arr[k] = R[j];
        j++;
        k++;
    }
}

/* Trippy mergesort */
int mergeSort(int64_t *sums, int l, int r, int lower, int upper)
{
    if (l > r) {
        return 0;
    }
    if(l==r) {
        return ( (sums[l]>=lower) && (sums[l]<=upper) )?1:0;
    }
    
    int m = l+(r-l)/2;
    int count=mergeSort(sums, l, m, lower, upper) + mergeSort(sums, m+1, r, lower, upper);

    int m1=m+1;
    int m2=m+1;
    for(int i=l; i<=m; i++) {
        while(m1<=r && sums[m1]-sums[i] < lower) {
            m1++;
        }
        while(m2<=r && sums[m2]-sums[i] <= upper) {
            m2++;
        }
        count+= m2-m1;
    }

    merge(sums, l, m, r);
    return count;
}

/* Optimized - Can i use a variation on merge sort? */
int countRangeSum(int* nums, int numsSize, int lower, int upper) {
    int64_t sums[numsSize+1];
    memset(sums, 0, sizeof(int64_t)*(numsSize+1));
    for(int i=0; i<numsSize; i++) {
        sums[i+1]=sums[i]+nums[i];
    }
    return mergeSort(sums, 1, numsSize, lower, upper);
}
