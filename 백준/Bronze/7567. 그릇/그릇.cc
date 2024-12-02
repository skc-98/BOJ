#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	int ans = 10;
	for (int i = 1; i < s.length(); i++) {
		if (s[i] == s[i - 1]) ans += 5;
		else ans += 10;
	}
	cout << ans;
	return 0;
}