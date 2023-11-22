#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 1; i <= tc; i++) {
		int n;
		cin >> n;
		vector<int> v(n + 1);
		int last = 0;
		for (int j = 1; j <= n; j++) {
			int a;
			cin >> a;
			last += a;
			v[j] = last;
		}
		int ans = -999999;
		for (int j = 1; j <= n; j++) {
			for (int k = 1; k <= j; k++) {
				ans = max(ans, v[j] - v[k - 1]);
			}
		}
		cout << ans << '\n';
	}

	return 0;
}