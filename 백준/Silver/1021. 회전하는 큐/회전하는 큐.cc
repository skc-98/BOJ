#include<iostream>
#include<deque>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	deque<int> dq;
	for (int i = 1; i <= n; i++) dq.push_back(i);

	int ans = 0;
	for (int i = 0; i < m; i++) {
		int num;
		cin >> num;

		int idx = find(dq.begin(), dq.end(), num) - dq.begin();
		int left = idx;
		int right = dq.size() - idx;

		if (left <= right) {
			ans += left;
			while (left > 0) {
				left--;
				dq.push_back(dq.front());
				dq.pop_front();
			}
		}
		else {
			ans += right;
			while (right > 0) {
				right--;
				dq.push_front(dq.back());
				dq.pop_back();
			}
		}
		dq.pop_front();
	}
	cout << ans;
	return 0;
}