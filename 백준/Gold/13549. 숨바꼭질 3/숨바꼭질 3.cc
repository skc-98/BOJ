#include<iostream>
#include<queue>
#define MAX 100001
using namespace std;

bool visit[100001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	queue<pair<int,int>> q;
	q.push({ n,0 });
	visit[n] = 1;

	while (!q.empty()) {
		int now = q.front().first;
		int time = q.front().second;
		q.pop();

		if (now == m) {
			cout << time;
			break;
		}

		if (now * 2 < MAX && !visit[now * 2]) {
			q.push({ now * 2,time });
			visit[now * 2] = true;
		}
		if (now - 1 >= 0 && !visit[now - 1]) {
			q.push({ now - 1,time + 1 });
			visit[now - 1] = true;
		}
		if (now + 1 < MAX && !visit[now + 1]) {
			q.push({ now + 1, time + 1 });
			visit[now + 1] = true;
		}
	}

	return 0;
}