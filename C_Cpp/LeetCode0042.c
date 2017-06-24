#include<stdio.h>
#include<stdlib.h>

int trap(int* height, int heightSize) {
	
	int leftMax = *height, rightMax = height[heightSize - 1];
	int i = 0, j = heightSize -1, result = 0;
	while(i <= j)
	{
		while (leftMax <= rightMax && i <= j && height[i] < leftMax) result += leftMax - height[i++];
		if(height[i] >= leftMax)
		{
			leftMax = height[i];
			i++;
		}
		while (rightMax < leftMax && i <= j && height[j] < rightMax) result += rightMax - height[j--];
		if(height[j] >= rightMax)
		{
			rightMax = height[j];
			j--;
		}
	}
	return result;
}

int main()
{
 	int bar[] = {2,0,2};
	printf("%d\n", trap(bar,3));
	system("pause");
	return 0;
}
