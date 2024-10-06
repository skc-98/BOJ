#include<iostream>
#include<queue>
using namespace std;

int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int d[1001][1001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	queue<pair<int, int>> q;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> d[i][j];
			if (d[i][j] == 1) q.push({ i,j });
		}
	}

	int days = -1;
	while (!q.empty()) {
		int tomato = q.size();
		days++;

		for (int i = 0; i < tomato; i++) {
			int x = q.front().first;
			int y = q.front().second;
			q.pop();

			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n && d[nx][ny] == 0) {
					d[nx][ny] = 1;
					q.push({ nx, ny });
				}
			}
		}
	}

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (d[i][j] == 0) {
				cout << -1;
				return 0;
			}
		}
	}

	cout << days;
	return 0;
}