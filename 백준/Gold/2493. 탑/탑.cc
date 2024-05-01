#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;

    stack<pair<int, int>> st;
    vector<int> ans;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        while (!st.empty() && st.top().first < a) {
            st.pop();
        }
        if (st.empty()) {
            ans.push_back(0);
        }
        else {
            ans.push_back(st.top().second);
        }
        st.push(make_pair(a, i + 1));
    }
    for (int i = 0; i < n; i++) cout << ans[i] << " ";
    return 0;
}