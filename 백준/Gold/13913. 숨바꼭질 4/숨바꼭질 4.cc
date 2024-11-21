#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>
using namespace std;

#define MAX 100001

bool visit[MAX];
int before[MAX];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	queue<pair<int, int>> q;
	q.push({ n,0 });
	visit[n] = 1;
	before[n] = -1;

	while (!q.empty()) {
		int now = q.front().first;
		int time = q.front().second;
		q.pop();

		if (now == m) {
			cout << time << '\n';
			vector<int> ans;
			int curr = m;
			while (curr != -1) {
				ans.push_back(curr);
				curr = before[curr];
			}
			reverse(ans.begin(), ans.end());
			for (int i = 0; i < ans.size(); i++) cout << ans[i] << " ";
			break;
		}

		if (now * 2 < MAX && !visit[now * 2]) {
			q.push({ now * 2,time + 1 });
			visit[now * 2] = true;
			before[now * 2] = now;
		}
		if (now - 1 >= 0 && !visit[now - 1]) {
			q.push({ now - 1,time + 1 });
			visit[now - 1] = true;
			before[now - 1] = now;
		}
		if (now + 1 < MAX && !visit[now + 1]) {
			q.push({ now + 1, time + 1 });
			visit[now + 1] = true;
			before[now + 1] = now;
		}
	}

	return 0;
}