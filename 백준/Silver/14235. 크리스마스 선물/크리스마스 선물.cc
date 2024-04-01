#include<iostream>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	priority_queue<int> q;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (a == 0) {
			if (q.empty()) {
				cout << -1 << '\n';
				continue;
			}
			else {
				cout << q.top() << '\n';
				q.pop();
				continue;
			}
		}
		else {
			for (int j = 0; j < a; j++) {
				int b;
				cin >> b;
				q.push(b);
			}
		}
	}

	return 0;
}