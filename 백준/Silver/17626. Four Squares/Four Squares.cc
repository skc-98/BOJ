#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> v;
	for (int i = 1; i * i <= n; i++) {
		v.push_back(i * i);
	}

	vector<int> dp(n + 1, n);
	dp[0] = 0;

	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < v.size(); j++) {
			if (i < v[j]) break;
			dp[i] = min(dp[i], dp[i - v[j]] + 1);
		}
	}
	cout << dp[n];
	return 0;
}