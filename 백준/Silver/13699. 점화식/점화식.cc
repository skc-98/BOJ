#include<iostream>
#include<vector>
using namespace std;

long long f(int n, vector<long long>& dp) {
	if (n == 0) return 1;
	if (dp[n] != -1) return dp[n];
	long long ans = 0;
	for (int i = 0; i < n; i++) {
		ans += f(i, dp) * f(n - 1 - i, dp);
	}
	dp[n] = ans;
	return ans;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	
	vector<long long> dp(n + 1, -1);
	cout << f(n, dp);
	return 0;
}