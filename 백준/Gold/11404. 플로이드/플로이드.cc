#include<iostream>
#include<algorithm>
#define MAX 999999999
using namespace std;

int floyd[101][101] = { 0, };

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, bus;
	cin >> n;
	cin >> bus;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j) continue;
			floyd[i][j] = MAX;
		}
	}

	for (int i = 1; i <= bus; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		floyd[a][b] = min(floyd[a][b], c);
	}

	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			if (i == k)  continue;
			for (int j = 1; j <= n; j++) {
				if (i == j) continue;
				if (j == k) continue;
				floyd[i][j] = min(floyd[i][j], floyd[i][k] + floyd[k][j]);
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (floyd[i][j] == MAX) {
				cout << 0 << " ";
				continue;
			}
			cout << floyd[i][j] << " ";
		}
		cout << endl;
	}
	return 0;
}