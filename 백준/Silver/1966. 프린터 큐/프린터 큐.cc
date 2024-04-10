#include<iostream>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 0; i < tc; i++) {
		int n, m;
		cin >> n >> m;
		
		queue<pair<int,int>> q;
		priority_queue<int> pq;
		int count = 0;

		for (int j = 0; j < n; j++) {
			int a;
			cin >> a;
			if (j == m) q.push(make_pair(a, 1));
			else q.push(make_pair(a, 0));
			pq.push(a);
		}
		while (1) {
			if (pq.top() == q.front().first) {
				count++;
				if (q.front().second == 1) {
					break;
				}
				pq.pop();
				q.pop();
			}
			else {
				pair<int, int> p = q.front();
				q.pop();
				q.push(p);
			}
		}
		cout << count << '\n';
	}
	return 0;
}