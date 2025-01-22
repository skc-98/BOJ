#include<iostream>
#include<vector>
using namespace std;

int d[15][15];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc; 

	for (int i = 1; i <= 14; i++) {
		d[0][i] = i;
	}

	for (int i = 1; i <= 14; i++) {
		for (int j = 1; j <= 14; j++) {
			d[i][j] = d[i - 1][j] + d[i][j - 1];
		}
	}

	for (int i = 0; i < tc; i++) {
		int k, n;
		cin >> k >> n;
		cout << d[k][n] << '\n';
	}

	return 0;
}