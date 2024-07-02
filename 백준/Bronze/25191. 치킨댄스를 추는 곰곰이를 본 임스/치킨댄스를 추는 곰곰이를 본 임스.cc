#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, a, b;
	cin >> n;
	cin >> a >> b;

	int ans = 0;
	while (1) {
		if (a < 2 && b < 1) break;
		if (n == 0) break;
		if (a >= 2 && n > 0) {
			ans++;
			a -= 2;
			n--;
		}
		if (b > 0 && n > 0) {
			ans++;
			b--;
			n--;
		}
	}
	cout << ans;
	return 0;
}