#include<iostream>
using namespace std;

int d[1001] = { 0, };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b, c;
	cin >> a >> b >> c;

	for (int i = 1; i <= 3; i++) {
		int n, m;
		cin >> n >> m;
		for (int j = n; j < m; j++) {
			d[j]++;
		}
	}
	int ans = 0;
	for (int i = 1; i <= 100; i++) {
		if (d[i] == 1) ans += a;
		else if (d[i] == 2) ans += b * 2;
		else if (d[i] == 3) ans += c * 3;
	}
	cout << ans;
	return 0;
}