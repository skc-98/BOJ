#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int ans = 0;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		if (a == 136) ans += 1000;
		else  if (a == 142) ans += 5000;
		else  if (a == 148) ans += 10000;
		else  if (a == 154) ans += 50000;
	}
	cout << ans;
	return  0;
}