#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	int ans = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] >= 'A' && s[i] <= 'F') {
			ans = ans * 16 + (s[i] - 'A' + 10);
		}
		else if (s[i] >= '0' && s[i] <= '9') {
			ans = ans * 16 + (s[i] - '0');
		}
	}
	cout << ans;
	return 0;
}