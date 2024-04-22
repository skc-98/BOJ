#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s, s2;
	getline(cin, s);
	getline(cin, s2);

	if (s.length() < s2.length()) {
		cout << 0;
		return 0;
	}

	int count = 0;
	int len = s2.length();
	for (int i = 0; i <= s.length() - s2.length(); i++) {
		string ss = s.substr(i, s2.length());
		if (ss == s2) {
			count++;
			i += (s2.length() - 1);
		}
		if (i > s.length() - s2.length()) break;
	}
	cout << count;
	return 0;
}