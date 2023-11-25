#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<vector<int>> v(n+1, vector<int> (n+1));
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			int a;
			cin >> a;
			v[i][j] = v[i][j - 1] + v[i - 1][j] - v[i - 1][j - 1] + a;
		}
	}

	for (int i = 1; i <= m; i++) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		cout << v[c][d] - v[a - 1][d] - v[c][b - 1] + v[a - 1][b - 1] << '\n';
	}

	return 0;
}