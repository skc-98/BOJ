#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		int d = a * 100 / n;
		if (d > 96) cout << 9 << " ";
		else if (d > 89) cout << 8 << " ";
		else if (d > 77) cout << 7 << " ";
		else if (d > 60) cout << 6 << " ";
		else if (d > 40) cout << 5 << " ";
		else if (d > 23) cout << 4 << " ";
		else if (d > 11) cout << 3 << " ";
		else if (d > 4) cout << 2 << " ";
		else cout << 1 << " ";
	}

	return 0;
}