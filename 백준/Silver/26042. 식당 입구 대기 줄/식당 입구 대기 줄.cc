#include<iostream>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	
	int max = 0, min = 999999;
	queue<int> q;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (a == 1) {
			int b;
			cin >> b;
			q.push(b);
		}
		else if (a == 2) {
			q.pop();
		}
		if (max < q.size()) {
			max = q.size();
			min = q.back();
		}
		else if (max == q.size()) {
			if (min > q.back()) min = q.back();
		}
	}

	cout << max << " " << min;
	return 0;
}