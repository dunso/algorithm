char li[][5] = {
	"abc",
	"def",
	"ghi",
	"jkl",
	"mno",
	"pqrs",
	"tuv",
	"wxyz"
};

char** letterCombinations(char* digits, int* returnSize) {
	int i = 0, k, n = 1;

	while (digits[i] != '\0') {
		n *= digits[i] == '7' || digits[i] == '9' ? 4 : 3;
		i++;
	}

	*returnSize = i == 0 ? 0 : n;

	char ** ret = (char**)malloc(sizeof(char*) *n);

	for (int j = 0; j < n; j++) {

		ret[j] = (char*)malloc(sizeof(char)*(i + 1));

		int m = j;

		for (k = 0; k < i; k++) {

			int p = digits[k] == '7' || digits[k] == '9' ? 4 : 3;

			ret[j][k] = li[digits[k] - '2'][m%p];

			m = m / p;
		}
		ret[j][k] = '\0';
	}
	return ret;
}
