#include<iostream>
#include<queue>
#include<string>
using namespace std;

bool visit[251][251];
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

	int sheep = 0, wolf = 0;
	queue<pair<int, int>>  q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (v[i][j] != '#' && !visit[i][j]) {
				int sh = 0;
				int wo = 0;
				if (v[i][j] == 'k') sh++;
				if (v[i][j] == 'v') wo++;
				q.push({ i,j });
				visit[i][j] = 1;
				while (!q.empty()) {
					pair<int, int> now = q.front(); q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = now.first + dx[k];
						int ny = now.second + dy[k];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if (visit[nx][ny] || v[nx][ny] == '#') continue;
						if (v[nx][ny] == 'v') wo++;
						if (v[nx][ny] == 'k') sh++;
						q.push({ nx,ny });
						visit[nx][ny] = 1;
					}
				}
				if (sh > wo) sheep += sh;
				else wolf += wo;
			}
		}
	}

	cout << sheep << " " << wolf;
	return 0;
}