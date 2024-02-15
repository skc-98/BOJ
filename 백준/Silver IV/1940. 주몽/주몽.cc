#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n;
	cin >> m;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	int ans = 0;
	int l = 0, r = n - 1;
	while (l < r) {
		int sum = v[l] + v[r];
		if (sum == m) ans++;
		if (sum < m) l++;
		else if (sum >= m) r--;
	}
	
	cout << ans;
	return 0;
}