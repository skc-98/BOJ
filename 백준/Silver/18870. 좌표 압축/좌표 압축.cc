#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
	return a.second < b.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<int, int>> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(make_pair(a, i));
	}

	sort(v.begin(), v.end());

	int count = 0;
	int pre;
	for (int i = 0; i < v.size(); i++) {
		if (i == 0) {
			pre = v[i].first;
			v[i].first = 0;
			continue;
		}
		if (v[i].first == pre) v[i].first = v[i - 1].first;
		else {
			pre = v[i].first;
			count++;
			v[i].first = count;
		}
	}

	sort(v.begin(), v.end(), cmp);
	
	for (int i = 0; i < v.size(); i++) {
		cout << v[i].first << " ";
	}
	return 0;
}