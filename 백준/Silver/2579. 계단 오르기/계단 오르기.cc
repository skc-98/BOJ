#include<iostream>
using namespace std;

int stairs[301];
int dp[301];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> stairs[i];
	}

	dp[1] = stairs[1];
	dp[2] = stairs[1] + stairs[2];

	for (int i = 3; i <= n; i++) {
		dp[i] = stairs[i] + max(stairs[i - 1] + dp[i - 3], dp[i - 2]);
	}
	cout << dp[n];
	return 0;
}