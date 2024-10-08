#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;

int visit[51][51];
int direction[2] = { -1,1 };
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
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < v[i].size(); j++) {
			if (visit[i][j]) continue;
			if (v[i][j] == '-') {
				ans++;
				q.push({ i,j });
				visit[i][j] = 1;

				while (!q.empty()) {
					pair<int, int> now = q.front();
					q.pop();
					for (int k = 0; k < 2; k++) {
						int x = now.second + direction[k];
						if (x >= m || x < 0 || visit[i][x] || v[i][x] != '-') continue;
						q.push({ i,x });
						visit[i][x] = 1;
					}
				}
			}
			if (v[i][j] == '|') {
				ans++;
				q.push({ i,j });
				visit[i][j] = 1;

				while (!q.empty()) {
					pair<int, int> now = q.front();
					q.pop();
					for (int k = 0; k < 2; k++) {
						int y = now.first + direction[k];
						if (y >= n || y < 0 || visit[y][j] || v[y][j] != '|') continue;
						q.push({ y, j });
						visit[y][j] = 1;
					}
				}
			}
		}
	}
	cout << ans;
	return 0;
}