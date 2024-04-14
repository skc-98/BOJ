#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	double n, m, ans = 0;
	cin >> n >> m;

    if (n < 5) ans = m;
    else if (n < 10) ans = m - 500;
    else if (n < 15) ans = min(m - 500, m * 0.9);
    else if (n < 20) ans = min(min(m - 500, m * 0.9), m - 2000.0);
    else ans = min(min(m - 500, m * 0.9), min(m - 2000.0, m * 0.75));
    if (ans < 0) cout << 0;
    else cout << ans;
	return 0;
}