#include<iostream>
using namespace std;

int dp[15];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	dp[1] = 1; dp[2] = 2; dp[3] = 4;

	for (int i = 4; i <= 11; i++) {
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
	}

	for (int i = 0; i < tc; i++) {
		int n;
		cin >> n;
		cout << dp[n] << endl;;
	}

	return 0;
}