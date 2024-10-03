#include<iostream>
#include<string>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int visit[26][26];
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

	int count = 0;
	vector<int> ans;
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < v[i].size(); j++) {
			int cnt = 0;
			if (v[i][j] == '1' && !visit[i][j]) {
				count++;
				q.push({ i,j });
				visit[i][j] = 1;
				cnt++;

				while (!q.empty()) {
					pair<int, int> now = q.front();
					q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = now.first + dx[k];
						int ny = now.second + dy[k];
						
						if (nx < 0 || nx >= n || ny < 0 || ny >= v[nx].size()) continue;
						if (visit[nx][ny] || v[nx][ny] == '0') continue;

						q.push({ nx,ny });
						visit[nx][ny] = 1;
						cnt++;
					}
				}
				ans.push_back(cnt);
			}
		}
	}
	sort(ans.begin(), ans.end());

	cout << count << '\n';
	for (int i = 0; i < ans.size(); i++) cout << ans[i] << '\n';
	return 0;
}