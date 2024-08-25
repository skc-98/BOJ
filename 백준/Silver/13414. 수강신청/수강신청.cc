#include<iostream>
#include<unordered_map>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<string, int>& a, const pair<string, int>& b) {
	return a.second < b.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	unordered_map<string, int> mp;
	for (int i = 0; i < m; i++) {
		string s;
		cin >> s;
		if (mp.find(s) != mp.end()) {
			mp.find(s)->second = i;
		}
		else mp[s] = i;
	}

	vector<pair<string, int>> v(mp.begin(), mp.end());
	sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < min(n, (int)v.size()); i++) {
		cout << v[i].first << '\n';
	}

	return 0;
}