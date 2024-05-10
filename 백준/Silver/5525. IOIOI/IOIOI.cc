#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	string s;
	cin >> n;
	cin >> m;
	cin >> s;

	int ans = 0;
	for (int i = 0; i < m; i++) {
		if (s[i + 1] == 'O' && s[i + 2] == 'I') {
			int tmp = 0;
			while (s[i] == 'I' && s[i + 1] == 'O') {
				i += 2;
				tmp++;
				if (s[i] == 'I' && tmp == n) {
					ans++;
					tmp--;
				}
			}
		}
	}
	cout << ans;
	return 0;
}