#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int d[101][101][101];
int visit[101][101][101];
int dx[6] = { -1, 1, 0, 0, 0, 0 };
int dy[6] = { 0, 0, -1, 1, 0, 0 };
int dz[6] = { 0, 0, 0, 0, -1, 1 };
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m, h;
    cin >> n >> m >> h;

    queue<vector<int>> q;

    for (int i = 0; i < h; i++) {
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                cin >> d[i][j][k];
                if (d[i][j][k] == 1) {
                    q.push({ i, j, k });
                    visit[i][j][k] = 0;
                }
                else if (d[i][j][k] == 0) {
                    visit[i][j][k] = -1;
                }
            }
        }
    }

    int ans = 0;
    while (!q.empty()) {
        int z = q.front()[0];
        int y = q.front()[1];
        int x = q.front()[2];
        q.pop();

        for (int t = 0; t < 6; t++) {
            int nz = z + dz[t];
            int ny = y + dy[t];
            int nx = x + dx[t];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
            if (d[nz][ny][nx] == 0 && visit[nz][ny][nx] == -1) {
                visit[nz][ny][nx] = visit[z][y][x] + 1;
                d[nz][ny][nx] = 1;
                q.push({ nz, ny, nx });
                ans = max(ans, visit[nz][ny][nx]);
            }
        }
    }

    for (int i = 0; i < h; i++) {
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                if (d[i][j][k] == 0) {
                    cout << -1;
                    return 0;
                }
            }
        }
    }

    cout << ans;
    return 0;
}