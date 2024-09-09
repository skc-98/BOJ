#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	vector<int> v2;
	v2.push_back(v[0] - 0);
	for (int i = 0; i < v.size() - 1; i++) {
		v2.push_back(v[i + 1] - v[i]);
	}
	sort(v2.begin(), v2.end());

	if (m >= n) {
		cout << 0;
		return 0;
	}

	int ans = 0;
	for (int i = 0; i < v2.size() - m; i++) {
		ans += v2[i];
	}
	cout << ans;
	return 0;
}