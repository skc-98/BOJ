#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		if ((a & (a - 1)) == 0) {
			cout << 1 << '\n';
		}
		else cout << 0 << '\n';
	}

	return 0;
}