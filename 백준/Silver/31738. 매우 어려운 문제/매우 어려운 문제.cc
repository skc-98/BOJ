#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long n, m;
	cin >> n >> m;

	long long ans = 1;
	for (int i = 1; i <= n; i++) {
		ans = (ans * i) % m;
		if (ans == 0) break;
	}
	cout << ans % m;
	return 0;
}