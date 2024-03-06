#include<iostream>
using namespace std;

int d[1001] = { 0, };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		d[a]++;
		if (d[a] <= 2) ans++;
	}
	cout << ans;
	return 0;
}