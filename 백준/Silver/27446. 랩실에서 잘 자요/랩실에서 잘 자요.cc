#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n,m;
    cin >> n >> m;
    vector<bool> paper(m);
    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;
        paper[num - 1] = 1;
    }
    int seg_cnt = 0;
    int paper_cnt = 0;
    int x = 0;
    while (x < n && paper[x]) x++;
    while (x < n) {
        while (x < n && !paper[x]) {
            if (seg_cnt == 0) {
                seg_cnt++;
            }
            paper_cnt++;
            x++;
        }
        if (x + 2 < n && !paper[x + 2]) {
            paper_cnt += 3;
            x += 3;
        } else if (x + 1 < n && !paper[x + 1]) {
            paper_cnt += 2;
            x += 2;
        } else {
            while (x < n && paper[x]) {
                x++;
            }
            if (x >= n) break;
            seg_cnt++;
            paper_cnt++;
            x++;
        }
    }
    cout << 5 * seg_cnt + 2 * paper_cnt << "\n";
    return 0;
}