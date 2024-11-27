#include<iostream>
#include<vector>
#include<queue>
using namespace std;

bool visit[10001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}

	int a, b;
	cin >> a >> b;
	a--;
	b--;

	queue<pair<int, int>> q;
	q.push({ a,0 });
	visit[a] = 1;

	while (!q.empty()) {
		pair<int, int> now = q.front(); q.pop();

		if (now.first == b) {
			cout << now.second;
			return 0;
		}
		for (int i = v[now.first]; i < n; i += v[now.first]) {
			int next = now.first + i;
			if (next < n && !visit[next]) {
				q.push({ next, now.second + 1 });
				visit[next] = 1;
			}
			next = now.first - i;
			if (next >= 0 && !visit[next]) {
				q.push({ next,now.second + 1 });
				visit[next] = 1;
			}
		}
	}
	cout << -1;
	return 0;
}