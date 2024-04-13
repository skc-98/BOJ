#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<int, vector<int>>& a, const pair<int, vector<int>>& b) {
	if (a.second[0] == b.second[0]) {
		if (a.second[1] == b.second[1]) {
			return a.second[2] > b.second[2];
		}
		return a.second[1] > b.second[1];
	}
	return a.second[0] > b.second[0];
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<pair<int, vector<int>>> v;
	for (int i = 0; i < n; i++) {
		int c;
		cin >> c;
		v.push_back(make_pair(c, vector<int>()));
		for (int j = 0; j < 3; j++) {
			int a;
			cin >> a;
			v[i].second.push_back(a);
		}
	}
	sort(v.begin(), v.end(), cmp);

	vector<int> rank(n, 1);
	for (int i = 1; i < n; i++) {
		if (v[i].second == v[i - 1].second) {
			rank[i] = rank[i - 1];
		}
		else {
			rank[i] = i + 1;
		}
	}


	for (int i = 0; i < n; i++) {
		if (v[i].first == m) {
			cout << rank[i];
			break;
		}
	}
	return 0;
}