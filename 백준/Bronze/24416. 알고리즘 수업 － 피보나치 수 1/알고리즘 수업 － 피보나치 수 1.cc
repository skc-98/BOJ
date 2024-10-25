#include<iostream>
using namespace std;

int cnt = 0;
int fib(int n) {
	cnt++;
	if (n == 1 || n == 2) {
		return 1;
	}
	return fib(n - 1) + fib(n - 2);
}

int d[101];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	fib(n);

	int count = 0;
	d[1] = 1;
	d[2] = 1;
	for (int i = 3; i <= n; i++) {
		d[i] = d[i - 2] + d[i - 1];
		count++;
	}

	cout << cnt / 2 + 1 << " " << count;
	return 0;
}