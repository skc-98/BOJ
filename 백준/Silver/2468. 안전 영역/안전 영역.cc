#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int high = 0;
	vector<vector<int>> v(n, vector<int>(n));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> v[i][j];
			if (v[i][j] > high) high = v[i][j];
		}
	}

	int ans = 0;
	queue<pair<int, int>> q;
	vector<vector<int>> visit(n, vector<int>(n));
	for (int rain = 0; rain <= high; rain++) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			fill(visit[i].begin(), visit[i].end(), 0);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (v[i][j] > rain && !visit[i][j]) {
					cnt++;
					q.push({ i,j });
					visit[i][j] = 1;
					while (!q.empty()) {
						pair<int, int> now = q.front(); q.pop();
						for (int k = 0; k < 4; k++) {
							int nx = now.first + dx[k];
							int ny = now.second + dy[k];
							if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
							if (v[nx][ny] <= rain || visit[nx][ny]) continue;
							q.push({ nx,ny });
							visit[nx][ny] = 1;
						}
					}
				}
			}
		}
		if (cnt > ans) ans = cnt;
	}
	cout << ans;
	return 0;
}