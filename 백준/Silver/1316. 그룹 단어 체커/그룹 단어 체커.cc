#include<iostream>
#include<string>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int count = n;
	for (int i = 1; i <= n; i++) {
		string s;
		cin >> s;

		int d[1001] = { 0, };

		d[s[0]] = 1;
		for (int j = 1; j < s.length(); j++) {
			if (s[j] != s[j - 1] && d[s[j]] == 1) { count--; break; }
			if (s[j] != s[j - 1]) d[s[j]] = 1;
		}
	}
	cout << count;
	return 0;
}