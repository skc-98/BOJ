#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		int count = i;
		for (int j = 1; j <= i; j++) {
			cout << "*";
		}
		for (int j = 1; j <= (n - i)*2; j++) {
			cout << " ";
		}
		for (int j = 1; j <= i; j++) {
			cout << "*";
		}
		cout << '\n';
	}
	for (int i = 1; i < n; i++) {
		int count = i;
		for (int j = 1; j <= (n - i); j++) {
			cout << "*";
		}
		for (int j = 1; j <= i*2; j++) {
			cout << " ";
		}
		for (int j = 1; j <= (n - i); j++) {
			cout << "*";
		}
		cout << '\n';
	}

	return 0;
}