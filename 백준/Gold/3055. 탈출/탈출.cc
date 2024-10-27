#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int visit[51][51];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	queue<pair<int, int>> q1;
	queue<pair<int, int>> q2;
	vector<string> v;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		v.push_back(s);
		for (int j = 0; j < s.length(); j++) {
			if (v[i][j] == 'S') {
				q1.push({ i, j });
				visit[i][j] = 1;
			}
			if (v[i][j] == '*') {
				q2.push({ i, j });
				visit[i][j] = -1;
			}
		}
	}

	bool reach = 0;
	int ans = 0;
	while (!q1.empty() && !reach) {
		int watersize = q2.size();
		for (int i = 0; i < watersize; i++) {
			pair<int, int> wnow = q2.front(); q2.pop();
			for (int j = 0; j < 4; j++) {
				int nx = wnow.first + dx[j];
				int ny = wnow.second + dy[j];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && v[nx][ny] == '.') {
					v[nx][ny] = '*';
					q2.push({ nx, ny });
				}
			}
		}

		int gosize = q1.size();
		for (int i = 0; i < gosize; i++) {
			pair<int, int> now = q1.front(); q1.pop();
			for (int j = 0; j < 4; j++) {
				int nx = now.first + dx[j];
				int ny = now.second + dy[j];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (v[nx][ny] == 'D') {
						ans = visit[now.first][now.second];
						reach = true;
						break;
					}
					if (v[nx][ny] == '.' && visit[nx][ny] == 0) {
						visit[nx][ny] = visit[now.first][now.second] + 1;
						q1.push({ nx, ny });
					}
				}
			}
			if (reach) break;
		}
	}

	if (reach) cout << ans;
	else cout << "KAKTUS";
	return 0;
}