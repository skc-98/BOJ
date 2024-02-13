#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 0; i < tc; i++) {
		int a, b;
		cin >> a >> b;

		vector<int> v;
		for (int j = 0; j < a; j++) {
			int a;
			cin >> a;
			v.push_back(a);
		}
		sort(v.begin(), v.end());

		int ans = 0;
		int l = 0, r = a - 1;
		long long mindiff = 999999999;
		while (l < r) {
			long long sum = v[l] + v[r];
			long long diff = abs(b - sum);
			if (diff < mindiff) {
				mindiff = diff;
				ans = 1;
			}
			else if (diff == mindiff) ans++;
			if (sum < b) l++;
			else if (sum >= b) r--;
		}
		cout << ans << '\n';
	}

	return 0;
}