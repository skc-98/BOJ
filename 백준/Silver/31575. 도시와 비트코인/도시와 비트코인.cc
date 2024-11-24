#include<iostream>
#include<queue>
using namespace std;

int d[301][301];
bool visit[301][301];
int dx[2] = { 0,1 };
int dy[2] = { 1,0 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> d[i][j];
		}
	}

	queue<pair<int, int>> q;
	q.push({ 0,0 });
	visit[0][0] = 1;
	while (!q.empty()) {
		pair<int, int> now = q.front(); q.pop();
		for (int i = 0; i < 2; i++) {
			int nx = now.first + dx[i];
			int ny = now.second + dy[i];
			if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
			if (visit[nx][ny] || !d[nx][ny]) continue;
			q.push({ nx,ny });
			visit[nx][ny] = 1;
		}
	}
	if (visit[m - 1][n - 1] == true) cout << "Yes";
	else cout << "No";
	return 0;
}