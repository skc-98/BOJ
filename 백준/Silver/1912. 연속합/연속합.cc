#include<iostream>
using namespace std;

int d[100001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int ans = -99999999;
	int sum = 0;
	for (int i = 0; i < n; i++) {
		cin >> d[i];
		sum += d[i];
		ans = max(ans, sum);
		if (sum < 0) sum = 0;
	}

	cout << ans;
	return 0;
}