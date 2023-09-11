#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	while (1) {
		char d[101][101] = { 0, };
		int n, m;
		cin >> n >> m;
		if (n == 0 && m == 0) break;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				cin >> d[i][j];
			}
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				count = 0;
				if (d[i][j] == '*') {
					cout << '*';
					continue;
				}
				if (d[i - 1][j] == '*') count++;
				if (d[i][j - 1] == '*') count++;
				if (d[i + 1][j] == '*') count++;
				if (d[i][j + 1] == '*') count++;
				if (d[i - 1][j - 1] == '*') count++;
				if (d[i - 1][j + 1] == '*') count++;
				if (d[i + 1][j - 1] == '*') count++;
				if (d[i + 1][j + 1] == '*') count++;
				cout << count;
			}
			cout << '\n';
		}
	}

	return 0;
}