#include<iostream>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	priority_queue<long long, vector<long long>, greater<>> q;
	for (int i = 0; i < n; i++) {
		long long a;
		cin >> a;
		q.push(a);
	}

	for (int i = 0; i < m; i++) {
		long long a = q.top();
		q.pop();
		long long b = q.top();
		q.pop();
		long long sum = a + b;
		q.push(sum); q.push(sum);
	}
	long long sum = 0;
	while (!q.empty()) {
		sum += q.top();
		q.pop();
	}
	cout << sum;
	return 0;
}