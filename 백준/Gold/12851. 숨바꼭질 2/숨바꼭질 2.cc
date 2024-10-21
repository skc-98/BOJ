#include<iostream>
#include<queue>
using namespace std;

int visit[100001];
int ways[100001];
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    if (n == m) {
        cout << 0 << '\n';
        cout << 1;
        return 0;
    }

    queue<int> q;
    q.push(n);
    visit[n] = 0;
    ways[n] = 1;

    while (!q.empty()) {
        int now = q.front(); q.pop();
        int next[3] = { now + 1, now - 1, now * 2 };

        for (int i = 0; i < 3; i++) {
            int np = next[i];
            if (np < 0 || np > 100000) continue;

            if (visit[np] == 0) {
                visit[np] = visit[now] + 1;
                ways[np] = ways[now];
                q.push(np);
            }
            else if (visit[np] == visit[now] + 1) {
                ways[np] += ways[now];
            }
        }
    }

    cout << visit[m] << '\n';
    cout << ways[m];

    return 0;
}