#include<iostream>
#include<numeric>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		long long a, b;
		cin >> a >> b;
		cout << (a*b)/gcd(a, b) << '\n';
	}

	return 0;
}