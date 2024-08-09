#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		int a, b, c;
		cin >> a >> b >> c;

		if (a > c) swap(a, c);
		if (b > c) swap(b, c);

		cout << "Scenario #" << i << ":" << '\n';
		if ((a * a) + (b * b) == (c * c)) {
			cout << "yes" << '\n';
		}
		else cout << "no" << '\n';
		cout << '\n';
	}

	return 0;
}