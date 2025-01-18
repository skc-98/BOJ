#include<iostream>
#include<string>
#include<climits>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string a, b;
	cin >> a >> b;

	int distance = b.length() - a.length();

	int ans = INT_MAX;
	for (int i = 0; i <= distance; i++) {
		int cnt = a.length();
		for (int j = i; j < i + a.length(); j++) {
			if (a[j - i] == b[j]) {
				cnt--;
			}
		}
		if (cnt < ans) ans = cnt;
	}
	cout << ans;
	return 0;
}