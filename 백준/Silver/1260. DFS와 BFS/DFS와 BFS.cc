#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

vector<int> v[1001];
bool checkd[1001];
bool checkb[1001];

void dfs(int node) {
	cout << node << " ";
	checkd[node] = true;
	for (int i = 0; i < v[node].size(); i++) {
		int next = v[node][i];
		if (!checkd[next]) {
			dfs(next);
		}
	}
}

void bfs(int node) {
	queue<int>  q;
	q.push(node);
	cout << node << " ";
	checkb[node] = true;
	while (!q.empty()) {
		int n = q.front();
		q.pop();
		for (int i = 0; i < v[n].size(); i++) {
			int next = v[n][i];
			if (!checkb[next]) {
				q.push(next);
				checkb[next] = 1;
				cout << next << " ";
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m, start;
	cin >> n >> m >> start;

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for (int i = 1; i <= n; i++) {
		sort(v[i].begin(), v[i].end());
	}

	dfs(start);
	cout << '\n';
	bfs(start);

	return 0;
}