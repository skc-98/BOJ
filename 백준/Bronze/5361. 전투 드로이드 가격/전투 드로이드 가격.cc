#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 1; i <= tc; i++) {
		int a, b, c, d, e;
		cin >> a >> b >> c >> d >> e;
		double answer = 0;
		answer += (a * 350.34);
		answer += (b * 230.90);
		answer += (c * 190.55);
		answer += (d * 125.30);
		answer += (e * 180.90);
		cout << fixed;
		cout.precision(2);
		cout << "$" << answer << '\n';
	}
	return 0;
}