#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		if (i % 2 == 1) {
			for (int i = 1; i <= n; i++) {
				cout << "*";
				if (i != n) cout << " ";
			}
			cout << '\n';
		}
		else {
			for (int i = 1; i <= n; i++) {
				cout << " *";
			}
			cout << '\n';
		}
	}

	return 0;
}