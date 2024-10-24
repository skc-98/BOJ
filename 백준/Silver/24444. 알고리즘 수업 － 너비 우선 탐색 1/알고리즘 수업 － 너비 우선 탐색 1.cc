#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;

vector<int> v[100001];
int visit[100001];
int cnt = 1;
void bfs(int r) {
	queue<int> q;
	q.push(r);
	visit[r] = cnt;
	cnt++;

	while (!q.empty()) {
		int now = q.front(); q.pop();
		for (int i = 0; i < v[now].size(); i++) {
			int next = v[now][i];
			if (!visit[next]) {
				q.push(next);
				visit[next] = cnt;
				cnt++;
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m, r;
	cin >> n >> m >> r;

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	for (int i = 0; i < n; i++) {
		sort(v[i].begin(), v[i].end());
	}

	bfs(r);

	for (int i = 1; i <= n; i++) {
		cout << visit[i] << '\n';
	}

	return 0;
}