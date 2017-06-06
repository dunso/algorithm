#include<iostream>
#include<string>
#include<unordered_map>

using namespace std;

class LeetCode13 {
public:
	int romanToInt(string s) {
		static unordered_map<char, int> map = {
			{ 'I', 1 },{ 'V', 5 },{ 'X', 10 },{ 'L', 50 },{ 'C', 100 },{ 'D', 500 },{ 'M', 1000 }
		};

		int sum = map[s.back()];

		for (int i = 0; i < s.length() - 1; i++) {
			sum = map[s[i]] < map[s[i + 1]] ? sum - map[s[i]] : sum + map[s[i]];
		}
		return sum;
	}
};

//int main() {
//	LeetCode13 leetCode13;
//	cout << leetCode13.romanToInt("MMMCMXCIX") << endl;
//	system("pause");
//	return 0;
//}