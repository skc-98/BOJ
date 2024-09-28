#include<iostream>
using namespace std;

long long dp[200];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	dp[1] = 1; dp[2] = 1; dp[3] = 1;
	for (int i = 4; i <= n; i++) {
		dp[i] = dp[i - 1] + dp[i - 3];
	}
	cout << dp[n];
	return 0;
}