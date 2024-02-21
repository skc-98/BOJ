#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		double a;
		cin >> a;
		cout << fixed;
		cout.precision(2);
		cout << "$" << a * 0.8 << '\n';
	}

	return 0;
}