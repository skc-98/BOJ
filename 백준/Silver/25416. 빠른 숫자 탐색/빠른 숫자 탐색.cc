#include<iostream>
#include<queue>
#include<cstring>
using namespace std;

int d[5][5];
int visit[5][5];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			cin >> d[i][j];
		}
	}
	int r, c;
	cin >> r >> c;

	memset(visit, -1, sizeof(visit));
	queue<pair<int, int>> q;
	q.push({ r,c });
	visit[r][c] = 0;
	while (!q.empty()) {
		pair<int, int> now = q.front(); q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = now.first + dx[i];
			int ny = now.second + dy[i];
			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
			if (d[nx][ny] == -1 || visit[nx][ny] != -1) continue;
			q.push({ nx,ny });
			visit[nx][ny] = visit[now.first][now.second] + 1;
			if (d[nx][ny] == 1) {
				cout << visit[nx][ny];
				return 0;
			}
		}
	}
	cout << -1;
	return 0;
}