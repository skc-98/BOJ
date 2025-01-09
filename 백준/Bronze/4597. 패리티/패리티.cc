#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		string s;
		cin >> s;
		if (s == "#") break;
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == '1') cnt++;
			if (s[i] == 'e') {
				if (cnt % 2 == 1) s[i] = '1';
				else s[i] = '0';
			}
			if (s[i] == 'o') {
				if (cnt % 2 == 1) s[i] = '0';
				else s[i] = '1';
			}
		}
		cout << s << '\n';
	}

	return 0;
}