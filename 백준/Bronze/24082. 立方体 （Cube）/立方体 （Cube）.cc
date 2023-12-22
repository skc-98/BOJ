#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	unsigned long long n;
	unsigned long long ans;
	cin >> n;
	ans = n * n * n;
	cout << ans;

	return 0;
}