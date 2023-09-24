#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

bool cmp(pair<int, string> a, pair<int, string> b) {
	if (a.first != b.first) return a.first < b.first;
	return false;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<int, string>> v;
	for (int i = 1; i <= n; i++) {
		int a; string b;
		cin >> a >> b;
		v.push_back(make_pair(a, b));
	}

	stable_sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < v.size(); i++) {
		cout << v[i].first << " " << v[i].second << '\n';
	}

	return 0;
}