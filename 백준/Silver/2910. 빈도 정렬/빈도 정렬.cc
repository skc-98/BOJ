#include<iostream>
#include<map>
#include<vector>
#include<algorithm>
using namespace std;

vector<int> order;
bool cmp(const pair<int,int>& a, const pair<int,int>& b){
	if (a.second == b.second) {
		return find(order.begin(), order.end(), a.first) < find(order.begin(), order.end(), b.first);
	}
	return a.second > b.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, c;
	cin >> n >> c;
	
	map<int, int> mp;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		mp[a]++;
		order.push_back(a);
	}

	vector<pair<int, int>> v;
	for (const auto& i : mp) {
		v.push_back(make_pair(i.first,i.second));
	}
	stable_sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < v.size(); i++) {
		for (int j = 0; j < v[i].second; j++) {
			cout << v[i].first << " ";
		}
	}
	return 0;
}