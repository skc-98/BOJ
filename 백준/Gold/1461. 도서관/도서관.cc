#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v;
	vector<int> v2;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (a > 0) v.push_back(a);
		else v2.push_back(-a);
	}
	sort(v.begin(), v.end());
	sort(v2.begin(), v2.end());

	int ans = 0;
	for (int i = v2.size() - 1; i >= 0; i -= m) {
		ans += v2[i] * 2;
	}
	for (int i = v.size() - 1; i >= 0; i -= m) {
		ans += v[i] * 2;
	}
	if (v.size() > 0 && v2.size() > 0) {
		if (v2[v2.size() - 1] > v[v.size() - 1]) ans -= v2[v2.size() - 1];
		else ans -= v[v.size() - 1];
	}
	else if (v2.size() > 0) ans -= v2[v2.size() - 1];
	else ans -= v[v.size() - 1];

	cout << ans;
	return 0;
}