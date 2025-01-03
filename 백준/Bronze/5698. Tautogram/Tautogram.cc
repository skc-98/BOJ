#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		string s;
		getline(cin, s);
		if (s == "*") break;

		char st = s[0];
		if (st >= 'A' && st <= 'Z') st = st + 32;

		bool check = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s[i] == ' ' && i + 1 < s.length()) {
				char next = s[i + 1];
				if (next >= 'A' && next <= 'Z') {
					next = next + 32;
				}
				if (next != st) {
					check = 0;
					break;
				}
			}
		}
		if (check) cout << "Y" << '\n';
		else cout << "N" << '\n';
	}
	return 0;
}