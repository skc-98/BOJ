#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	if (n % 5 == 0) {
		cout << n / 5;
		return 0;
	}
	else {
		int f = n / 5;
		while (f>=0) {
			int answer = (n - (f * 5)) % 2;
			int t = (n - (f * 5)) / 2;
			if (answer == 0) {
				cout << f + t;
				return 0;
			}
			f--;
		}
	}
	cout << -1;
	return 0;
}