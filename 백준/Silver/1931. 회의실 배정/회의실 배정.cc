#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<int,int>& a, const pair<int,int>& b) {
	if (a.second == b.second) return a.first < b.first;
	return a.second < b.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<int, int>> v;
	for (int i = 1; i <= n; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back(make_pair(a, b));
	}

	sort(v.begin(), v.end(), cmp);
	
	int t = v[0].second;
	int count = 1;
	for (int i = 1; i < n; i++) {
		if (t <= v[i].first) {
			count++;
			t = v[i].second;
		}
	}
	cout << count;
	return 0;
}