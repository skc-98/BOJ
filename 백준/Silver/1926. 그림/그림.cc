#include<iostream>
#include<queue>
using namespace std;

int d[501][501];
int v[501][501];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> d[i][j];
		}
	}

	int paint = 0;
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (v[i][j] == 1 || d[i][j] == 0) continue;
			paint++;
			int count = 0;
			queue<pair<int, int>> q;
			q.push({ i,j });
			v[i][j] = 1;

			while (!q.empty()) {
				pair<int, int> now = q.front();
				q.pop();
				count++;
				
				int x = now.first;
				int y = now.second;

				if (x - 1 >= 1 && v[x - 1][y] == 0 && d[x - 1][y] == 1) {
					q.push({ x - 1, y });
					v[x - 1][y] = 1;
				}
				if (x + 1 <= n && v[x + 1][y] == 0 && d[x + 1][y] == 1) {
					q.push({ x + 1, y });
					v[x + 1][y] = 1;
				}
				if (y - 1 >= 1 && v[x][y - 1] == 0 && d[x][y - 1] == 1) {
					q.push({ x, y - 1 });
					v[x][y - 1] = 1;
				}
				if (y + 1 <= m && v[x][y + 1] == 0 && d[x][y + 1] == 1) {
					q.push({ x, y + 1 });
					v[x][y + 1] = 1;
				}
			}
			if (ans < count) ans = count;
		}
	}
	cout << paint << '\n';
	cout << ans << '\n';
	return 0;
}