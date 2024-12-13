#include<iostream>
#include<queue>
using namespace std;

int d[101][101];
int visit[101][101];
int dx[8] = { -1,-1,-1,0,1,1,1,0 };
int dy[8] = { -1,0,1,1,1,0,-1,-1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> d[i][j];
		}
	}

	int ans = 0;
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!visit[i][j] && d[i][j] != 0) {
				bool top = 1;
				q.push({ i,j });
				visit[i][j] = 1;
				while (!q.empty()) {
					pair<int, int> now = q.front(); q.pop();
					for (int k = 0; k < 8; k++) {
						int nx = now.first + dx[k];
						int ny = now.second + dy[k];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if (d[i][j] < d[nx][ny]) top = false;
						if (!visit[nx][ny] && d[i][j] == d[nx][ny]) {
							visit[nx][ny] = 1;
							q.push({ nx,ny });
						}
					}
				}
				if (top) ans++;
			}
		}
	}
	cout << ans;
	return 0;
}