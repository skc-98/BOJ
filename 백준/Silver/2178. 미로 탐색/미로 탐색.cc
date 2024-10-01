#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;

bool visit[101][101];
int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };
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

	queue<pair<int, int>> q;
	q.push({ 0,0 });
	visit[0][0] = 1;
	vector<vector<int>> d(n, vector<int>(m, 0));
	d[0][0] = 1;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny] && v[nx][ny] == '1') {
				q.push({ nx, ny });
				visit[nx][ny] = true;
				d[nx][ny] = d[x][y] + 1;
			}
		}
	}
	cout << d[n - 1][m - 1];
	return 0;
}