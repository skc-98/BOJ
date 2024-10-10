#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int visit[1001][1001];
int ans[1001][1001];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	queue<pair<int, int>> q;
	vector<vector<int>> v(n, vector<int>(m, 0));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> v[i][j];
			if (v[i][j] == 2) {
				q.push({ i, j });
				visit[i][j] = 1;
				ans[i][j] = 0;
			}
		}
	}

	while (!q.empty()) {
		pair<int, int> now = q.front();
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nx = now.first + dx[k];
			int ny = now.second + dy[k];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if (visit[nx][ny] || !v[nx][ny]) continue;

			q.push({ nx,ny });
			visit[nx][ny] = 1;
			ans[nx][ny] = ans[now.first][now.second] + 1;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!visit[i][j] && v[i][j] != 0) {
				cout << -1 << " ";
				continue;
			}
			cout << ans[i][j] << " ";
		}
		cout << '\n';
	}
	return 0;
}