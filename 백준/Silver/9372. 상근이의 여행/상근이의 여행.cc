#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int prim(int n, vector<vector<int>>& v) {
	vector<bool> check(n, false);
	priority_queue < pair<int, int>, vector <pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push(make_pair(0, 0));
	
	int mst = 0;
	while (!pq.empty()) {
		int u = pq.top().second;
		pq.pop();
		if (check[u]) continue;
		check[u] = true;
		mst++;
		for (int i = 0; i < n; i++) {
			if (v[u][i] && !check[i]) pq.push(make_pair(v[u][i], i));
		}
	}
	return mst - 1;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int t = 0; t < tc; t++) {
		int n, m;
		cin >> n >> m;

		vector<vector<int>> v(n, vector<int>(n, 0));
		for (int i = 0; i < m; i++) {
			int a, b;
			cin >> a >> b;
			v[a - 1][b - 1] = v[b - 1][a - 1] = 1;
		}
		cout << prim(n, v) << '\n';
	}

	return 0;
}