#include<iostream>
#include<vector>
#include<deque>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	deque<pair<int, int>> dq(n);
	for (int i = 1; i <= n; i++) {
		dq[i - 1] = make_pair(i, i);
		cin >> dq[i - 1].first;
	}

	while (1) {
		if (dq.size() == 0) break;
		int front = dq.front().first;
		cout << dq.front().second << " ";
		dq.pop_front();
		if (dq.empty()) break;
		if (front > 0) {
			for (int i = 0; i < front - 1; i++) {
				dq.push_back(dq.front());
				dq.pop_front();
			}
		}
		else {
			for (int i = 0; i < abs(front); i++) {
				dq.push_front(dq.back());
				dq.pop_back();
			}
		}

	}
	return 0;
}