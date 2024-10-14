#include<iostream>
#include<vector>
#include<queue>
using namespace std;

vector<int> d[10001];
bool visit[10001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		d[b].push_back(a);
	}

	int max = 0;
	vector<int> ans;
	queue<int> q;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			visit[j] = false;
		}

		int sum = 0;
		q.push(i);
		visit[i] = 1;

		while (!q.empty()) {
			int now = q.front(); q.pop();
			for (int j = 0; j < d[now].size(); j++) {
				int next = d[now][j];
				if (!visit[next]) {
					visit[next] = true;
					q.push(next);
					sum++;
				}
			}
		}

		if (sum > max) {
			max = sum;
			ans.clear();
			ans.push_back(i);
		}
		else if (sum == max) ans.push_back(i);
	}

	for (int i = 0; i < ans.size(); i++) cout << ans[i] << " ";
	return 0;
}