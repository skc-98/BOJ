#include<iostream>
#include<algorithm>
#include<numeric>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		int a, b;
		cin >> a >> b;
		cout << gcd(a, b) << '\n';
	}

	return 0;
}