#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int visit[1001][1001];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<vector<int>> v(n, vector<int>(m));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int r, g, b;
			cin >> r >> g >> b;
			v[i][j] = (r + g + b) / 3;
		}
	}

	int bound;
	cin >> bound;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (v[i][j] >= bound) v[i][j] = 255;
			else v[i][j] = 0;
		}
	}

	int ans = 0;
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (v[i][j] == 255 && !visit[i][j]) {
				ans++;
				q.push({ i,j });
				visit[i][j] = 1;
				while (!q.empty()) {
					pair<int, int> now = q.front(); q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = now.first + dx[k];
						int ny = now.second + dy[k];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if (visit[nx][ny] || v[nx][ny] == 0) continue;
						q.push({ nx,ny });
						visit[nx][ny] = 1;
					}
				}
			}
		}
	}
	cout << ans;
	return 0;
}