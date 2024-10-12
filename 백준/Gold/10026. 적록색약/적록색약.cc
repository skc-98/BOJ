#include<iostream>
#include<vector>
#include<queue>
using namespace std;

bool d[101][101];
bool t[101][101];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<string> v;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		v.push_back(s);
	}

	int ans1 = 0;
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < v[i].size(); j++) {
			if (d[i][j]) continue;
			q.push({ i,j });
			d[i][j] = 1;
			ans1++;
			while (!q.empty()) {
				pair<int, int> now = q.front();
				q.pop();
				for (int k = 0; k < 4; k++) {
					int nx = now.first + dx[k];
					int ny = now.second + dy[k];
					if (nx < 0 || nx >= n || ny < 0 || nx >= v[i].size()) continue;
					if (d[nx][ny]) continue;
					if (v[nx][ny] != v[now.first][now.second]) continue;
					q.push({ nx,ny });
					d[nx][ny] = 1;
				}
			}
		}
	}

	int ans2 = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < v[i].size(); j++) {
			if (t[i][j]) continue;
			if (v[i][j] == 'R' || v[i][j] == 'G') {
				q.push({ i,j });
				t[i][j] = 1;
				ans2++;
				while (!q.empty()) {
					pair<int, int> now = q.front();
					q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = now.first + dx[k];
						int ny = now.second + dy[k];
						if (nx < 0 || nx >= n || ny < 0 || nx >= v[i].size()) continue;
						if (t[nx][ny]) continue;
						if (v[nx][ny] != 'R' && v[nx][ny] != 'G') continue;
						q.push({ nx,ny });
						t[nx][ny] = 1;
					}
				}
			}
			else {
				q.push({ i,j });
				t[i][j] = 1;
				ans2++;
				while (!q.empty()) {
					pair<int, int> now = q.front();
					q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = now.first + dx[k];
						int ny = now.second + dy[k];
						if (nx < 0 || nx >= n || ny < 0 || nx >= v[i].size()) continue;
						if (t[nx][ny]) continue;
						if (v[nx][ny] != 'B') continue;
						q.push({ nx,ny });
						t[nx][ny] = 1;
					}
				}
			}
		}
	}

	cout << ans1 << " " << ans2;
	return 0;
}