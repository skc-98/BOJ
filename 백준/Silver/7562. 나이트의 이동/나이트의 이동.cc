#include<iostream>
#include<queue>
using namespace std;

int dx[8] = { 1,2,2,1,-1,-2,-2,-1 };
int dy[8] = { 2,1,-1,-2,-2,-1,1,2 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 0; i < tc; i++) {
		int visit[301][301] = { 0, };
		int n, a, b, da, db;
		cin >> n;
		cin >> a >> b;
		cin >> da >> db;

		queue<pair<int, int>> q;
		q.push({ a,b });
		visit[a][b] = 1;
		while (!q.empty()) {
			pair<int, int> now = q.front(); q.pop();
			if (now.first == da && now.second == db) {
				cout << visit[now.first][now.second] - 1 << '\n';
				break;
			}
			for (int j = 0; j < 8; j++) {
				int nx = now.first + dx[j];
				int ny = now.second + dy[j];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (visit[nx][ny]) continue;
				q.push({ nx,ny });
				visit[nx][ny] = visit[now.first][now.second] + 1;
			}
		}
	}
	return 0;
}