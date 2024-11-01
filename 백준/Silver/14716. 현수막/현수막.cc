#include<iostream>
#include<queue>
using namespace std;

int d[251][251];
int visit[251][251];
int dx[8] = { -1,1,0,0,-1,1,-1,1 };
int dy[8] = { 0,0,-1,1,-1,-1,1,1 };
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
			if (d[i][j] == 1 && !visit[i][j]) {
				ans++;
				q.push({ i,j });
				visit[i][j] = 1;
				while (!q.empty()) {
					pair<int, int> now = q.front(); q.pop();
					for (int k = 0; k < 8; k++) {
						int nx = now.first + dx[k];
						int ny = now.second + dy[k];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if (!d[nx][ny] || visit[nx][ny]) continue;
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