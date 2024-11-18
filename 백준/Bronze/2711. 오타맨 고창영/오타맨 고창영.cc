#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int a; string s;
		cin >> a >> s;
		string ans = "";
		for (int j = 0; j < s.length(); j++) {
			if (a - 1 == j) continue;
			ans += s[j];
		}
		cout << ans << '\n';
	}

	return 0;
}