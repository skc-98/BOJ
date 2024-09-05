#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	string ans = "";
	cin >> s;

	string ss="";
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'X') {
			ss += 'X';
		}
		if (ss.length() == 4) {
			ans += "AAAA";
			ss = "";
		}
		if (s[i] == '.') {
			if (ss.length() % 2 != 0) {
				cout << -1;
				return 0;
			}
			else if (ss.length() == 2) {
				ans += "BB";
				ss = "";
			}
			ans += '.';
		}
	}
	if (ss.length() > 0) {
		if (ss.length() % 2 != 0) {
			cout << -1;
			return 0;
		}
		else if (ss.length() == 2) {
			ans += "BB";
		}
	}

	cout << ans;
	return 0;
}