#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m;
	cin >> n;
	cin >> m;
	string s;
	cin >> s;

	string ioi = "I";
	for (int i = 1; i <= n; i++) {
		ioi += "OI";
	}

	int ans = 0;
	for (int i = 0; i < s.length(); i++) {
		int state = 0;
		int count = 0;
		if (s[i] == 'I') {
			for (int j = i; j < i + ioi.length(); j++) {
				if (s[j] == ioi[count]) count++;
				else {
					state = 1;
					break;
				}
			}
		}
		if (s[i] != 'I') state = 1;
		if (state == 0) {
			ans++;
		}
	}

	cout << ans;
	return 0;
}