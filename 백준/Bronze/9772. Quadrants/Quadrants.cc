#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		double a, b;
		cin >> a >> b;
		if (a == 0 && b == 0) {
			cout << "AXIS" << '\n';
			return 0;
		}
		else if (a == 0 || b == 0) {
			cout << "AXIS" << '\n';
		}
		else {
			if (a > 0 && b > 0) cout << "Q1" << '\n';
			else if (a > 0 && b < 0) cout << "Q4" << '\n';
			else if (a < 0 && b < 0) cout << "Q3" << '\n';
			else if (a < 0 && b > 0) cout << "Q2" << '\n';
		}
	}

	return 0;
}