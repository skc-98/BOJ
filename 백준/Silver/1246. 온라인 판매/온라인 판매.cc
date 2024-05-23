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
	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	int ans = 0, max = 0;
	for (int i = 0; i < v.size(); i++) {
		if ((v.size() - i) > n && v[i] * n > max) {
			ans = v[i];
			max = v[i] * n;
		}
		else if (v[i] * (v.size() - i) > max) {
			ans = v[i];
			max = v[i] * (v.size() - i);
		}
	}
	cout << ans << " " << max;
	return 0;
}