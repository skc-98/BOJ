#include<iostream>
#include<vector>
using namespace std;

vector<int> v[101];
bool check[101];

int dfs(int n) {
	int count = 1;
	check[n] = true;
	for (int i = 0; i < v[n].size(); i++) {
		int next = v[n][i];
		if (!check[next]) {
			count += dfs(next);
		}
	}
	return count;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n;
	cin >> m;

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	
	int ans = dfs(1) - 1;
	cout << ans;
	return 0;
}