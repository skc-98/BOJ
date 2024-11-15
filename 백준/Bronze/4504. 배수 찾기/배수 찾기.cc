#include<iostream>
using namespace std;

int  main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	while (1) {
		int a;
		cin >> a;
		if (a == 0)  break;
		if (a % n == 0) cout << a << " is a multiple of " << n << "." << '\n';
		else cout << a << " is NOT a multiple of " << n << "." << '\n';
	}

	return 0;
}