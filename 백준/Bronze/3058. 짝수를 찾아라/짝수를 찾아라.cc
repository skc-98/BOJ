#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 0; i < tc; i++) {
		int min = 99999999;
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			int a;
			cin >> a;
			if (a % 2 == 0) {
				if (a < min) min = a;
				sum += a;
			}
		}
		cout << sum << " " << min << '\n';
	}

	return 0;
}