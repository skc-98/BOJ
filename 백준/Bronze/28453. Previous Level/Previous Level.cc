#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (a == 300) cout << 1 << " ";
		else if (a < 300 && a >= 275) cout << 2 << " ";
		else if (a < 275 && a >= 250) cout << 3 << " ";
		else cout << 4 << " ";
	}

	return 0;
}