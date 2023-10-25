#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		int n;
		cin >> n;
		if (n == 0) break;
		int count = 0;

		for (int i = n + 1; i <= 2 * n; i++) {
			if (i < 2) continue;
			bool state = true;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					state = false;
					break;
				}
			}
			if (state) count++;
		}
		cout << count << '\n';
	}
	return 0;
}