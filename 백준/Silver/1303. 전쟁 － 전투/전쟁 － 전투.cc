#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;

int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int visit[101][101];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<string> v;
	for (int i = 0; i < m; i++) {
		string s;
		cin >> s;
		v.push_back(s);
	}

	char color;
	int wsum = 0, bsum = 0;
	queue<pair<int, int>> q;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (!visit[i][j]) {
				q.push({ i,j });
				visit[i][j] = 1;
				color = v[i][j];
			}
			int qcount = 0;
			while (!q.empty()) {
				pair<int, int> now = q.front(); q.pop();
				qcount++;
				for (int k = 0; k < 4; k++) {
					int nx = now.first + dx[k];
					int ny = now.second + dy[k];
					if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
					if (visit[nx][ny] || color != v[nx][ny]) continue;
					q.push({ nx,ny });
					visit[nx][ny] = 1;
				}
			}
			if (color == 'B') {
				bsum += qcount * qcount;
			}
			else {
				wsum += qcount * qcount;
			}
		}
	}
	cout << wsum << " " << bsum;
	return 0;
}