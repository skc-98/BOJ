#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int a = n, b = n;
	for (int i = 1; i <= n; i++) {
		if (i == n) {
			for (int j = 1; j <= 2 * n - 1; j++) {
				cout << "*";
			}
			break;
		}
		for (int j = 1; j <= 2 * n - 1; j++) {
			if (j == a) {
				cout << "*";
				if (i == 1) {
					cout << " ";
					break;
				}
			}
			else if (j == b) {
				cout << "* ";
				break;
			}
			else {
				cout << " ";
			}
		}
		a--; b++;
		cout << '\n';
	}

	return 0;
}