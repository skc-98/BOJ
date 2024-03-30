#include<iostream>
#include<cmath>
#include<queue>
using namespace std;

struct cmp {
	bool operator() (int a, int b) {
		if (abs(a) == abs(b)) return a > b;
		return abs(a) > abs(b);
	}
};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	priority_queue<int, vector<int>, cmp> q;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (a == 0) {
			if (q.empty()) cout << 0 << '\n';
			else {
				cout << q.top() << '\n';
				q.pop();
			}
			continue;
		}
		q.push(a);
	}
	return 0;
}