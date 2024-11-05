#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, k;
	cin >> n >> k;
	string s;
	cin >> s;

	int ans = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'P') {
			int start = max(0, i - k);
			int end = min(n - 1, i + k);
			for (int j = start; j <= end; j++) {
				if (s[j] == 'H') {
					ans++;
					s[j] = 'E';
					break;
				}
			}
		}
	}
	cout << ans;
	return 0;
}