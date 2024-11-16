#include<iostream>
#include<deque>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, l;
	cin >> n >> l;

	deque<pair<int, int>> dq;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		while (!dq.empty() && dq.back().first >= a) dq.pop_back();
		dq.push_back({ a,i });
		if (dq.front().second <= i - l) dq.pop_front();
		cout << dq.front().first << " ";
	}
	return 0;
}