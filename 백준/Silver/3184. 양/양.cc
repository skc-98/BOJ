#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;

int visit[251][251];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<string> v;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		v.push_back(s);
	}

	int ssum = 0;
	int wsum = 0;
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int sheep = 0;
			int wolf = 0;
			if (v[i][j] != '#' && !visit[i][j]) {
				q.push({ i,j });
				visit[i][j] = 1;
				while (!q.empty()) {
					pair<int, int> now = q.front(); q.pop();
					if (v[now.first][now.second] == 'v') wolf++;
					if (v[now.first][now.second] == 'o') sheep++;
					for (int k = 0; k < 4; k++) {
						int nx = now.first + dx[k];
						int ny = now.second + dy[k];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if (v[nx][ny]=='#' || visit[nx][ny]) continue;
						q.push({ nx,ny });
						visit[nx][ny] = 1;
					}
				}
			}
			if (sheep > wolf) ssum += sheep;
			else wsum += wolf;
		}
	}
	cout << ssum << " " << wsum;
	return 0;
}