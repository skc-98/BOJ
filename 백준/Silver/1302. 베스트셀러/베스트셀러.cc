#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
using namespace std;

bool cmp(pair<string, int> a, pair<string, int> b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	return a.second > b.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<string, int>> v;
	for (int i = 0; i < n; i++) {
		string a;
		cin >> a;
		int check = 0;
		for (int j = 0; j < v.size(); j++) {
			if (v[j].first == a) {
				v[j].second++;
				check = 1;
				break;
			}
		}
		if (check == 0) {
			v.push_back(make_pair(a, 1));
		}
	}
	sort(v.begin(), v.end(), cmp);
	cout << v[0].first;
	return 0;
}