#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 1; i <= tc; i++) {
		long long n;
		cin >> n;
		if (n == 0 || n == 1) cout << 2 << '\n';
		else {
			while (1) {
				int state = 0;
				for (long long j = 2; j * j <= n; j++) {
					if (n % j == 0) {
						state = 1;
						break;
					}
				}
				if (state == 0) {
					cout << n << '\n';
					break;
				}
				else n++;
			}
		}
	}

	return 0;
}