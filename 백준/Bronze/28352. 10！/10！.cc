#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long n, ans = 1;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		ans *= i;
	}
	cout << ans/604800;
	return 0;
}