#include<iostream>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b, c;
	cin >> a >> b >> c;

	priority_queue<int> q;
	for (int i = 0; i < a; i++) {
		int n;
		cin >> n;
		if (n < b) continue;
		q.push(n);
	}

	int count = 0;
	for (int i = 0; i < c; i++) {
		if (q.empty()) break;
		int giant = q.top();
		if (giant < b) break;
		if (giant == 1) continue;
		giant /= 2;
		count++;
		q.pop();
		q.push(giant);
	}

	if (!q.empty() && q.top() >= b) {
		cout << "NO" << '\n';
		if (!q.empty()) cout << q.top();
	}
	else {
		cout << "YES" << '\n';
		cout << count;
	}
	return 0;
}