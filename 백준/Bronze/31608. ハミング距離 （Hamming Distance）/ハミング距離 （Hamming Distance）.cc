#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	string s, s2;
	cin >> s >> s2;

	int ans = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] != s2[i]) ans++;
	}
	cout << ans;
	return 0;
}