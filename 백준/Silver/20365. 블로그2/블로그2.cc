#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	string s;
	cin >> s;

	int rcount = 1;
	int bcount = 1;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'R') {
			if (s[i] == s.length() - 1) continue;
			if (s[i + 1] == 'R') continue;
			else {
				rcount++;
			}
		}
		if (s[i] == 'B') {
			if (s[i] == s.length() - 1) continue;
			if (s[i + 1] == 'B') continue;
			else {
				bcount++;
			}
		}
	}
	if (rcount > bcount) cout << bcount;
	else cout << rcount;
	return 0;
}