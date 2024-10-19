#include<iostream>
#include<queue>
using namespace std;

bool visit[100001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	if (n == m) {
		cout << 0;
		return 0;
	}

	queue<pair<int, int>> q;
	q.push({ n,0 });
	visit[n] = 1;

	while (!q.empty()) {
		pair<int, int> now = q.front(); q.pop();
		int next[3] = { now.first + 1, now.first - 1, now.first * 2 };
		for (int i = 0; i < 3; i++) {
			if (next[i] < 0 || next[i] > 100000) continue;
			if (visit[next[i]]) continue;
			if (next[i] == m) {
				cout << now.second + 1;
				return 0;
			}
			q.push({ next[i], now.second + 1 });
			visit[next[i]] = 1;
		}
	}
	return 0;
}