#include <stdlib.h>
#include <stdio.h>

struct Interval {
	int start;
	int end;
};

#define MIN(a, b) ((a) < (b)) ? (a) : (b)
#define MAX(a, b) ((a) > (b)) ? (a) : (b)

struct Interval* insert(struct Interval* intervals, int intervalsSize, struct Interval newInterval, int* returnSize) {

	int i = 0;
	while (i < intervalsSize && intervals[i].end < newInterval.start) i++;

	*returnSize = i;

	while (i < intervalsSize && intervals[i].start <= newInterval.end)
	{
		newInterval.start = MIN(intervals[i].start, newInterval.start);
		newInterval.end = MAX(intervals[i].end, newInterval.end);
		i++;
	}

	*returnSize += i < intervalsSize ? intervalsSize - i + 1 : 1;

	struct Interval * result = malloc(sizeof(struct Interval) * (*returnSize));

	i = 0;
	int count = 0;
	while (i < intervalsSize && intervals[i].end < newInterval.start)
	{
		result[count++] = intervals[i++];
	}

	while (i < intervalsSize && intervals[i].start <= newInterval.end) i++;
	result[count++] = newInterval;

	while(i < intervalsSize)
	{
		result[count++] = intervals[i++];
	}

	return result;
}

int main(void)
{
	struct Interval* intervals1 = (struct Interval *)malloc(sizeof(struct Interval) * 2);
	struct Interval* intervals2 = (struct Interval *)malloc(sizeof(struct Interval) * 5);
	struct Interval* intervals3 = NULL;
	struct Interval* intervals4 = (struct Interval *)malloc(sizeof(struct Interval));

	struct Interval new1;
	struct Interval new2;
	struct Interval new3;
	struct Interval new4;

	struct Interval* res = NULL;

	int size = 0;

	intervals1[0].start = 2;
	intervals1[0].end = 6;
	intervals1[1].start = 7;
	intervals1[1].end = 9;

	intervals2[0].start = 1;
	intervals2[0].end = 2;
	intervals2[1].start = 3;
	intervals2[1].end = 5;
	intervals2[2].start = 6;
	intervals2[2].end = 7;
	intervals2[3].start = 8;
	intervals2[3].end = 10;
	intervals2[4].start = 12;
	intervals2[4].end = 16;

	intervals4[0].start = 1;
	intervals4[0].end = 5;

	new1.start = 15;
	new1.end = 18;

	new2.start = 4;
	new2.end = 9;

	new3.start = 5;
	new3.end = 7;

	new4.start = 0;
	new4.end = 1;

	res = insert(intervals1, 2, new1, &size);

	int i;
	for (i = 0; i < size; i++)
	{
		printf("[%d, %d] ", res[i].start, res[i].end);
	}
	printf("\n");
	free(res);

	res = insert(intervals2, 5, new2, &size);
	for (i = 0; i < size; i++)
	{
		printf("[%d, %d] ", res[i].start, res[i].end);
	}
	printf("\n");
	free(res);

	res = insert(intervals3, 0, new3, &size);
	for (i = 0; i < size; i++)
	{
		printf("[%d, %d] ", res[i].start, res[i].end);
	}
	printf("\n");
	free(res);
	
	res = insert(intervals4, 1, new4, &size);
	for (i = 0; i < size; i++)
	{
		printf("[%d, %d] ", res[i].start, res[i].end);
	}
	printf("\n");
	free(res);

	system("pause");
	return 0;
}
