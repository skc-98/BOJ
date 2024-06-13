#include<iostream>
using namespace std;

int dp[32][32] = { 0, };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m, k;
	cin >> n >> m >> k;

	dp[1][1] = 1;
	for (int i = 1; i <= 31; i++) {
		for (int j = 1; j <= i; j++) {
			if (i == j) dp[i][j] = 1;
			else if (j == 1) dp[i][j] = 1;
			else {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
	}
	int sum = 0;
	for (int i = 0; i < k; i++) {
		for (int j = 0; j <= i; j++) {
			sum += dp[n + i][m + j];
		}
	}
	cout << sum;
	return 0;
}