#include<iostream>
#include<algorithm>
using namespace std;

int d[501][501];
int dp[501][501];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			cin >> d[i][j];
		}
	}
	dp[1][1] = d[1][1];
	for (int i = 2; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			dp[i][j] = max(dp[i - 1][j] + d[i][j], dp[i - 1][j - 1] + d[i][j]);
		}
	}

	int max = 0;
	for (int i = 1; i <= n; i++) {
		if (max < dp[n][i]) max = dp[n][i];
	}
	cout << max;
	return 0;
}