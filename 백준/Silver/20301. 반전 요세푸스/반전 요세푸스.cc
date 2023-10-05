#include<iostream>
#include<deque>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m, k;
	cin >> n >> m >> k;

	deque<int> dq;
	for (int i = 1; i <= n; i++) dq.push_back(i);

	vector<int> ans;
	int count = 0;
	int state = 0;
	while (1) {
		if (dq.empty() == true) break;
		if (state == 0) {
			for (int i = 1; i < m; i++) {
				dq.push_back(dq.front());
				dq.pop_front();
			}
			ans.push_back(dq.front());
			dq.pop_front();
			count++;
		}
		else if (state == 1) {
			for (int i = 1; i < m; i++) {
				dq.push_front(dq.back());
				dq.pop_back();
			}
			ans.push_back(dq.back());
			dq.pop_back();
			count++;
		}
		if (count == k) {
			count = 0;
			if (state == 0) state = 1;
			else state = 0;
		}
	}
	for (int i = 0; i < ans.size(); i++) cout << ans[i] << '\n';
	return 0;
}