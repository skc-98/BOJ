#include<iostream>
#include<queue>
#define MAX 1000001
using namespace std;

int visit[MAX];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	queue<pair<int, int>> q;
	q.push({ n,0 });
	visit[n] = 1;
	while (!q.empty()) {
		pair<int, int> now = q.front(); q.pop();
		if (now.first == m) {
			cout << now.second;
			break;
		}

		if (now.first + 1 < MAX && !visit[now.first + 1]) {
			q.push({ now.first + 1, now.second + 1 });
			visit[now.first + 1] = 1;
		}
		if (now.first * 2 < MAX && !visit[now.first * 2]) {
			q.push({ now.first * 2, now.second + 1 });
			visit[now.first * 2] = 1;
		}
	}

	return 0;
}