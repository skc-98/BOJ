#include<iostream>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, a, b;
	cin >> n >> a >> b;

	int ans = 0;
	int min = 99999;
	for (int i = a; i <= b; i++) {
		if (abs(n - i) < min) {
			min = abs(n - i);
			ans = i;
		}
	}
	cout << ans;
	return 0;
}