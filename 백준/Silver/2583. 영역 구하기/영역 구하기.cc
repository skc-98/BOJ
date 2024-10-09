#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

int visit[101][101];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m, k;
	cin >> n >> m >> k;
	vector<vector<int>> v(n, vector<int>(m, 0));

	for (int i = 0; i < k; i++) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		for (int x = b; x < d; x++) {
			for (int y = a; y < c; y++) {
				v[x][y] = 1;
				visit[x][y] = 1;
			}
		}
	}

	vector<int> ans;
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (visit[i][j] || v[i][j]) continue;
			int cnt = 1;
			q.push({ i,j });
			visit[i][j] = 1;
			while (!q.empty()) {
				pair<int, int> now = q.front();
				q.pop();
				for (int k = 0; k < 4; k++) {
					int nx = now.first + dx[k];
					int ny = now.second + dy[k];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if (visit[nx][ny] || v[nx][ny]) continue;
					q.push({ nx,ny });
					visit[nx][ny] = 1;
					cnt++;
				}
			}
			ans.push_back(cnt);
		}
	}
	sort(ans.begin(), ans.end());
	cout << ans.size() << '\n';
	for (int i = 0; i < ans.size(); i++) cout << ans[i] << " ";
	return 0;
}