#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;
	
	vector<int> v(n);
	int last = 0;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		last += a;
		v[i] = last;
	}

	int ans = v[m - 1];
	for (int i = m; i < n; i++) {
		ans = max(ans, v[i] - v[i - m]);
	}
	cout << ans;
	return 0;
}