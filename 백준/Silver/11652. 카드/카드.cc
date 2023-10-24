#include<iostream>
#include<map>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<long long, long long>& a, const pair<long long,long long>& b) {
	if (a.second != b.second) {
		return a.second > b.second;
	}
	return a.first < b.first;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	map<long long, long long> mp;
	for (int i = 1; i <= n; i++) {
		long long a;
		cin >> a;
		if (mp.find(a) != mp.end()) mp[a]++;
		else mp[a] = 1;
	}

	vector<pair<long long, long long>> v(mp.begin(), mp.end());
	sort(v.begin(), v.end(), cmp);
	cout << v[0].first;
	return 0;
}