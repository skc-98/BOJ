#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);cout.tie(NULL);

	int n;
	cin >> n;

	int ans = 0;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (i == n - 1) ans += a;
		else ans += a - 1;
	}
	cout << ans;
	return 0;
}