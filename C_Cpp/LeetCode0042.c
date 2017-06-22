#define MAX(x, y) (((x) > (y)) ? (x) : (y))
int trap(int* height, int heightSize) {

	int a = 0;
	int b = heightSize - 1;
	int max = 0;
	int leftmax = 0;
	int rightmax = 0;
	while (a <= b) {
		leftmax = MAX(leftmax, height[a]);
		rightmax = MAX(rightmax, height[b]);
		if (leftmax<rightmax) {
			max += (leftmax - height[a]);
			a++;
		}
		else {
			max += (rightmax - height[b]);
			b--;
		}
	}
	return max;
}
