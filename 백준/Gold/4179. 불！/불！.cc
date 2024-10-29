#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;

int visit[1001][1001];
int fireTime[1001][1001];
int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<string> v;
    queue<pair<int, int>> q1;
    queue<pair<int, int>> q2;

    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        v.push_back(s);
        for (int j = 0; j < m; j++) {
            fireTime[i][j] = -1;
            visit[i][j] = -1;
            if (v[i][j] == 'F') {
                q1.push({ i, j });
                fireTime[i][j] = 0;
            }
            if (v[i][j] == 'J') {
                q2.push({ i,j });
                visit[i][j] = 0;
            }
        }
    }

    while (!q1.empty()) {
        pair<int, int> fire = q1.front(); q1.pop();
        for (int i = 0; i < 4; i++) {
            int nx = fire.first + dx[i];
            int ny = fire.second + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (v[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;
            fireTime[nx][ny] = fireTime[fire.first][fire.second] + 1;
            q1.push({ nx, ny });
        }
    }

    while (!q2.empty()) {
        pair<int, int> now = q2.front(); q2.pop();
        if (now.first == 0 || now.first == n - 1 || now.second == 0 || now.second == m - 1) {
            cout << visit[now.first][now.second] + 1;
            return 0;
        }
        for (int i = 0; i < 4; i++) {
            int nx = now.first + dx[i];
            int ny = now.second + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (v[nx][ny] == '#' || visit[nx][ny] != -1) continue;
            if (fireTime[nx][ny] == -1 || visit[now.first][now.second] + 1 < fireTime[nx][ny]) {
                visit[nx][ny] = visit[now.first][now.second] + 1;
                q2.push({ nx, ny });
            }
        }
    }
    cout << "IMPOSSIBLE";
    return 0;
}