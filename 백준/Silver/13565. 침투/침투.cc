#include<iostream>
#include<vector>
#include<queue>
#include<string>
using namespace std;

int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int visit[1001][1001];
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
	for (int i = 0; i < m; i++) {
		if (v[0][i] == '0') {
			q.push({ 0,i });
			visit[0][i] = 1;
			while (!q.empty()) {
				pair<int, int> now = q.front(); q.pop();
				for (int j = 0; j < 4; j++) {
					int nx = now.first + dx[j];
					int ny = now.second + dy[j];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if (v[nx][ny]=='1' || visit[nx][ny]) continue;
					q.push({ nx,ny });
					visit[nx][ny] = 1;
					if (nx == n - 1) {
						cout << "YES";
						return 0;
					}
				}
			}
		}
	}
	cout << "NO";
	return 0;
}