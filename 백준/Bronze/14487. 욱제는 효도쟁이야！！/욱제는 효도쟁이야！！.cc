#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	int sum = 0;
	int max = 0;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		sum += a;
		if (a > max) max = a;
	}
	cout << sum - max;

	return 0;
}