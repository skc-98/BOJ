#include<iostream>
using namespace std;

long long factorial(int n) {
	long long fac = 1;
	for (int i = 1; i <= n; i++) {
		fac *= i;
	}
	return fac;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, a, b, c;
	cin >> n >> a >> b >> c;
	cout << factorial(n) / (factorial(a) * factorial(b) * factorial(c));
	return 0;
}