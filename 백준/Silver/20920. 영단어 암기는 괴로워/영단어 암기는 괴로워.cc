#include<iostream>
#include<map>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<string,int>& a, const pair<string,int>& b) {
	if (a.second != b.second) return a.second > b.second;
	else if (a.first.length() != b.first.length()) return a.first.length() > b.first.length();
	else return a.first < b.first;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;
	
	map<string, int> mp;
	for (int i = 0; i < n; i++) {
		string a;
		cin >> a;
		if (a.length() < m) continue;
		mp[a]++;
	}

	vector<pair<string, int>> v(mp.begin(), mp.end());
	sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < v.size(); i++) {
		cout << v[i].first << '\n';
	}
	return 0;
}