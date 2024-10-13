#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<pair<int, int>> v;
	vector<bool> check(n + 1, 0);
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back({ a,b });
	}

	int ans = 0;
	queue<int> q;
	for (int i = 1; i <= n; i++) {
		if (check[i] == 0) {
			ans++;
			q.push(i);
			check[i] = 1;
			while (!q.empty()) {
				int now = q.front();
				q.pop();
				for (int j = 0; j < m; j++) {
					if (v[j].first == now && !check[v[j].second]) {
						q.push(v[j].second);
						check[v[j].second] = 1;
					}
					if (v[j].second == now && !check[v[j].first]) {
						q.push(v[j].first);
						check[v[j].first] = 1;
					}
				}
			}
		}
	}
	cout << ans;
	return 0;
}