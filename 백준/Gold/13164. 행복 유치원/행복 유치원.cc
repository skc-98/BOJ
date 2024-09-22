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

	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}

	vector<int> v2;
	for (int i = 1; i < n; i++) {
		v2.push_back(v[i] - v[i - 1]);
	}
	sort(v2.begin(), v2.end(), greater<int>());

	int ans = 0;
	for (int i = m - 1; i < v2.size(); i++) {
		ans += v2[i];
	}
	cout << ans;
	return 0;
}