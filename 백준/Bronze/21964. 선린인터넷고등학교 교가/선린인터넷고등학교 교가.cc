#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	string s;
	cin >> s;

	if (s.length() <= 5) {
		cout << s;
		return 0;
	}

	string ans = "";
	for (int i = s.length() - 1; i >= s.length() - 5; i--) {
		ans += s[i];
	}
	reverse(ans.begin(), ans.end());
	cout << ans;
	return 0;
}