#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b, c;
	cin >> a >> b >> c;
	int m = max(a, b);
	if (m < c) m = c;

	int ans = 0;
	ans += m - a;
	ans += m - b;
	ans += m - c;
	cout << ans;
	return 0;
}