#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;

bool visit[101][101];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<string> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}

	int ans = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (v[i][j] == '#' && !visit[i][j]) {
				ans++;
				queue<pair<int, int>> q;
				q.push({ i,j });
				visit[i][j] = 1;
				while (!q.empty()) {
					pair<int, int> now = q.front(); q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = now.first + dx[k];
						int ny = now.second + dy[k];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if (v[nx][ny] == '.' || visit[nx][ny]) continue;
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