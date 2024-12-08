#include<iostream>
#include<deque>
#include<algorithm>
using namespace std;

bool cmp(int a, int b) {
	return  a > b;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	deque<int> dq;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		dq.push_back(a);
	}
	sort(dq.begin(), dq.end(), cmp);

	int ans = 0;
    while (!dq.empty()) {
        while (!dq.empty() && dq.front() == 0) {
            dq.pop_front();
        }
        if (dq.empty()) break;
        if (dq.size() == 1) {
            ans += dq.front();
            dq.pop_front();
        }
        else {
            int first = dq.front(); dq.pop_front();
            int second = dq.front(); dq.pop_front();
            first--;
            second--;
            if (first > 0) dq.push_back(first);
            if (second > 0) dq.push_back(second);
            sort(dq.begin(), dq.end(), cmp);
            ans++;
        }
        if (ans > 1440) {
            cout << -1 << "\n";
            return 0;
        }
    }
	cout << ans;
	return 0;
}