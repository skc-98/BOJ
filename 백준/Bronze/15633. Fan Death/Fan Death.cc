#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	long long sum = 0;
	for (int i = 1; i <= n; i++) {
		if (n % i == 0) sum += i;
	}
	cout << sum * 5 - 24;
	return 0;
}