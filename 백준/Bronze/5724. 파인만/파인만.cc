#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		int n;
		cin >> n;
		if (n == 0) break;

		int ans = 0;
		for (int i = n; i > 0; i--) ans += (i * i);
		cout << ans << '\n';
	}

	return 0;
}