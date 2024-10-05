#include <iostream>
#include <queue>
using namespace std;

int d[51][51];
int visit[51][51];
int dx[8] = { -1, 1, 0, 0, -1, -1, 1, 1 };
int dy[8] = { 0, 0, -1, 1, -1, 1, -1, 1 };

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    while (1) {
        int w, h;
        cin >> w >> h;
        if (w == 0 && h == 0) break;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cin >> d[i][j];
                visit[i][j] = 0;
            }
        }

        int ans = 0;
        queue<pair<int, int>> q;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (d[i][j] && !visit[i][j]) {
                    ans++;
                    visit[i][j] = 1;
                    q.push({ i,j });

                    while (!q.empty()) {
                        pair<int, int> now = q.front();
                        q.pop();

                        for (int k = 0; k < 8; k++) {
                            int nx = now.first + dx[k];
                            int ny = now.second + dy[k];
                            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                            if (visit[nx][ny] || !d[nx][ny]) continue;
                            visit[nx][ny] = 1;
                            q.push({ nx,ny });
                        }
                    }
                }
            }
        }
        cout << ans << '\n';
    }
    return 0;
}