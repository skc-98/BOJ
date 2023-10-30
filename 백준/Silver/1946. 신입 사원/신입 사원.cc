#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
	return a.first < b.first;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 1; i <= tc; i++) {
		int n;
		cin >> n;
		vector<pair<int, int>> v;
		for (int j = 1; j <= n; j++) {
			int a, b;
			cin >> a >> b;
			v.push_back(make_pair(a, b));
		}
		sort(v.begin(), v.end(), cmp);
		int count = 1;
		int best = v[0].second;
		for (int j = 1; j < v.size(); j++) {
			if (v[j].second < best) {
				count++;
				best = v[j].second;
			}
		}
		cout << count << '\n';
	}

	return 0;
}