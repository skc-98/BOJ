#include<iostream>
#include<string>
#include<vector>
#include<queue>
using namespace std;

int visit[601][601];
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

	queue<pair<int, int>> q;
	for (int i = 0; i < v.size(); i++) {
		for (int j = 0; j < v[i].length(); j++) {
			if (v[i][j] == 'I') {
				q.push({ i,j });
				visit[i][j] = 1;
			}
		}
	}

	int count = 0;
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && v[nx][ny] != 'X') {
				visit[nx][ny] = 1;
				q.push({ nx, ny });
				if (v[nx][ny] == 'P') count++;
			}
		}
	}
	if (count == 0) cout << "TT";
	else cout << count;
	return 0;
}