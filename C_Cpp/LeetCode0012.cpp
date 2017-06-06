#include <iostream>
#include <string>

using namespace std;

class LeetCode0012 {
public:
	string intToRoman(int num)
	{
		string table[4][10] = {
			{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
			{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
			{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
			{ "", "M", "MM", "MMM" }
		};
		return table[3][num / 1000] + table[2][num % 1000 / 100] + table[1][num % 100 / 10] + table[0][num % 10];
	}
};

//int main() {
//	LeetCode0012 leetCode0012 = LeetCode0012();
//	cout << leetCode0012.intToRoman(3999) << endl;
//	system("pause");
//	return 0;
//}