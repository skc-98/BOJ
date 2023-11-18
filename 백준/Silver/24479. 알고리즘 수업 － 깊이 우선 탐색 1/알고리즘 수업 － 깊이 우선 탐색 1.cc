#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int visited[100001];
vector<int> v[100005];
int order = 1;

void dfs(int now) {
	visited[now] = order;
	order++;
	for (int i = 0; i < v[now].size(); i++) {
		if (visited[v[now][i]] != 0) continue;
		dfs(v[now][i]);
	}
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m, r;
    cin >> n >> m >> r;

    for (int i = 1; i <= m; i++) {
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    for (int i = 1; i <= n; i++) sort(v[i].begin(), v[i].end());
    dfs(r);
    for (int i = 1; i <= n; i++) {
        cout << visited[i] << '\n';
    }
    return 0;
}