#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.first == b.first) return a.second > b.second;
	return a.first < b.first;
}

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
		v.push_back(make_pair(a, b));
	}

	sort(v.begin(), v.end(), cmp);

	int left = v[0].first;
	int lefthigh = v[0].second;
	int ans = 0;
	for (int i = 0; i < v.size(); i++) {
		if (lefthigh <= v[i].second) {
			ans += (v[i].first - left) * lefthigh;
			lefthigh = v[i].second;
			left = v[i].first;
		}
	}

	int right = v[n - 1].first;
	int righthigh = v[n - 1].second;
	for (int i = v.size() - 1; i >= 0; i--) {
		if (righthigh < v[i].second) {
			ans += (right - v[i].first) * righthigh;
			righthigh = v[i].second;
			right = v[i].first;
		}
	}
	ans += lefthigh;
	cout << ans;
	return 0;
}