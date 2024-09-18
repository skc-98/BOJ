#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	getline(cin, s);

	string ans = "UCPC";
	int idx = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == ans[idx]) idx++;
		if (idx == 4) {
			cout << "I love UCPC";
			return 0;
		}
	}
	cout << "I hate UCPC";
	return 0;
}