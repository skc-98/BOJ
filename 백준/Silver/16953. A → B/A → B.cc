#include<iostream>
#include<queue>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    long long n, m;
    cin >> n >> m;

    queue<pair<long long, int>> q;
    q.push({ n,1 });
    
    while (!q.empty()) {
        pair<long long, int> now = q.front(); q.pop();
        if (now.first == m) {
            cout << now.second;
            return 0;
        }
        if (now.first * 2 <= m) q.push({ now.first * 2,now.second + 1 });
        if (now.first * 10 + 1 <= m) q.push({ now.first * 10 + 1,now.second + 1 });
    }
    cout << -1;
    return 0;
}
