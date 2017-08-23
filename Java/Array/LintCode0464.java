import java.util.Arrays;
public class LintCode0464 {
	public void sortIntegers2(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		quickSort(A, 0, A.length - 1);
	}

	private void quickSort(int[] A, int left, int right) {
		if (left >= right) {
			return;
		}

		int swap = (int) (Math.random() * (right - left)) + left;

		int tmp = A[swap];
		A[swap] = A[left];
		A[left] = tmp;

		int mid = A[left];
		int i = left, j = right;

		boolean isRightNeedSort = false;
		boolean isLeftNeedSort = false;
		while (i < j) {
			while (i < j && A[j] >= mid) {
				j--;
				if (!isRightNeedSort && A[j] > A[j + 1]) {
					isRightNeedSort = true;
				}
			}

			if (i < j) {
				A[i] = A[j];
				if (!isLeftNeedSort && i - 1 >= left && A[i] < A[i - 1]) {
					isLeftNeedSort = true;
				}
			}
			while (i < j && A[i] < mid) {
				i++;
				if (!isLeftNeedSort && A[i] < A[i - 1]) {
					isLeftNeedSort = true;
				}
			}
			if (i < j) {
				A[j] = A[i];
				if (!isRightNeedSort && j + 1 <= right && A[j] > A[j + 1]) {
					isRightNeedSort = true;
				}
			}
		}
		A[i] = mid;

		if (isLeftNeedSort) {
			quickSort(A, left, i - 1);
		}

		if (isRightNeedSort) {
			quickSort(A, i + 1, right);
		}
	}

	public static void main(String[] args) {
		int[] A = { 3, 2, 1, 4, 5 };
		LintCode0464 lintCode = new LintCode0464();
		lintCode.sortIntegers2(A);
		System.out.println(Arrays.toString(A));
	}
}
