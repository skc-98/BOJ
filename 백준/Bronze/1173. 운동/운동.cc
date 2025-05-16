#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n, m, a, b, c;
    cin >> n >> m >> a >> b >> c;

    if (m + b > a) {
        cout << -1 << endl;
        return 0;
    }

    int now = m;
    int exercise = 0;
    int t = 0;

    while (exercise < n) {
        if (now + b <= a) {
            now += b;
            exercise++;
        } else {
            now -= c;
            if (now < m) now = m;
        }
        t++;
    }

    cout << t << endl;
    return 0;
}