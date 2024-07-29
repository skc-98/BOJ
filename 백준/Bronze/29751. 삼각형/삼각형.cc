#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;
	cout << fixed;
	cout.precision(1);
	double ans = n * m;
	cout << ans / 2;
	return 0;
}