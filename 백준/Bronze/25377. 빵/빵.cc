#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<int, int>> v;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		if (a <= b) v.push_back(make_pair(a, b));
	}

	if (v.empty()) {
		cout << -1;
		return 0;
	}

	int ans = 9999999;
	for (int i = 0; i < v.size(); i++) {
		if (ans > v[i].second) ans = v[i].second;
	}
	cout << ans;
	return 0;
}