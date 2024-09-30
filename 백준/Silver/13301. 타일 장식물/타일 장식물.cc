#include<iostream>
using namespace std;

long long dp[100];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	dp[1] = 1; dp[2] = 1;
	for (int i = 3; i <= 80; i++) {
		dp[i] = dp[i - 2] + dp[i - 1];
	}
	cout << dp[n] * 2 + ((dp[n] + dp[n - 1]) * 2);

	return 0;
}