#include<iostream>
#include<queue>
using namespace std;


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	priority_queue<double, vector<double>, greater<>> q;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		q.push(a);
	}

	while (1) {
		if (q.size() < 2) break;
		double x = q.top();
		q.pop();
		double y = q.top();
		q.pop();
		double avg = (x + y) / 2;
		q.push(avg);
	}
	cout << fixed;
	cout.precision(6);
	cout << q.top();
	return 0;
}