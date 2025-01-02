#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b, c;
	cin >> a >> b >> c;

	a += b;
	int ans = 0;
	while (a >= c) {
		int n = (a / c);
		ans += n;
		a = a % c + n;
	}
	cout << ans;
	return 0;
}