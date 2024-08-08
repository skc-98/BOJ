#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int ans = 0;
	ans = n * (n - 1) * (n - 2) * (n - 3) / 24;

	cout << ans;
	return 0;
}