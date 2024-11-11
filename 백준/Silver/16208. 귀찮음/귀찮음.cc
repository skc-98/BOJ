#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long n, pipe = 0, ans = 0;
	cin >> n;

	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
		pipe += v[i];
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < n - 1; i++) {
		ans += (v[i] * (pipe - v[i]));
		pipe -= v[i];
	}
	cout << ans;
	return 0;
}