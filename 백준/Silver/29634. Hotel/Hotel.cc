#include<iostream>
#include<vector>
#include<queue>
#include<string>
using namespace std;

int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
bool visit[31][31];
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

	int ans = -1;
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (v[i][j] != '*' && !visit[i][j]) {
				int sum = 1;
				visit[i][j] = true;
				q.push({ i,j });
				while (!q.empty()) {
					pair<int, int> now = q.front(); q.pop();
					for (int i = 0; i < 4; i++) {
						int nx = now.first + dx[i];
						int ny = now.second + dy[i];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if (v[nx][ny] == '*' || visit[nx][ny]) continue;
						q.push({ nx,ny });
						visit[nx][ny] = 1;
						sum++;
					}
				}
				if (sum > ans) ans = sum;
			}
		}
	}
	cout << ans;
	return 0;
}