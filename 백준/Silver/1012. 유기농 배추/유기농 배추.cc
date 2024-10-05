#include<iostream>
#include<queue>
using namespace std;

int d[51][51];
int visit[51][51];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int t = 1; t <= tc; t++) {
		int n, m, k;
		cin >> n >> m >> k;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				d[i][j] = 0;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j] = 0;
			}
		}

		for (int i = 0; i < k; i++) {
			int a, b;
			cin >> a >> b;
			d[a][b] = 1;
		}

		int ans = 0;
		queue<pair<int, int>> q;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (d[i][j] && !visit[i][j]) {
					ans++;
					q.push({ i,j });
					visit[i][j] = 1;

					while (!q.empty()) {
						pair<int, int> now = q.front();
						q.pop();
						for (int k = 0; k < 4; k++) {
							int nx = now.first + dx[k];
							int ny = now.second + dy[k];
							if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
							if (visit[nx][ny] || d[nx][ny] == 0) continue;
							q.push({ nx,ny });
							visit[nx][ny] = 1;
						}
					}
				}
			}
		}
		cout << ans << '\n';
		// d
	}

	return 0;
}