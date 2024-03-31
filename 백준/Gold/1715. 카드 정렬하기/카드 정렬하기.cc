#include<iostream>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	priority_queue<int, vector<int>, greater<>> q;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		q.push(a);
	}

	int ans = 0;
	for (int i = 0; i < n - 1; i++) {
		int a, b;
		a = q.top();
		q.pop();
		b = q.top();
		q.pop();
		ans += (a + b);
		q.push(a + b);
	}
	cout << ans;
	return 0;
}