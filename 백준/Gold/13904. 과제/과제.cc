#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<int,int>& a, const pair<int,int>& b) {
	return a.second > b.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	
	int max = 0;
	vector <pair<int, int>> v;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back(make_pair(a, b));
		if (max < a) max = a;
	}
	sort(v.begin(), v.end(), cmp);

	vector<bool> check(max + 1, false);
	int ans = 0;
	for (int i = 0; i < v.size(); i++) {
		for (int j = v[i].first; j > 0; j--) {
			if (!check[j]) {
				check[j] = true;
				ans += v[i].second;
				break;
			}
		}
	}
	cout << ans;
	return 0;
}