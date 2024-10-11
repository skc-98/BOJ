#include<iostream>
#include<queue>
using namespace std;

int d[51][51];
int dist[51][51];
int dx[8] = { -1,1,0,0,-1,-1,1,1 };
int dy[8] = { 0,0,-1,1,-1,1,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	queue<pair<int, int>> q;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> d[i][j];
			if (d[i][j] == 1) {
				q.push({ i, j });
				dist[i][j] = 0;
			}
			else {
				dist[i][j] = -1;
			}
		}
	}
	
	while (!q.empty()) {
		pair<int, int> now = q.front();
		q.pop();

		for (int k = 0; k < 8; k++) {
			int nx = now.first + dx[k];
			int ny = now.second + dy[k];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if (dist[nx][ny] != -1) continue;

			dist[nx][ny] = dist[now.first][now.second] + 1;
			q.push({ nx, ny });
		}
	}

	int ans = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (ans < dist[i][j]) ans = dist[i][j];
		}
	}
	cout << ans;
	return 0;
}