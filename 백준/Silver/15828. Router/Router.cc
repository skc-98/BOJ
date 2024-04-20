#include<iostream>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	queue<int> q;
	while (1) {
		int a;
		cin >> a;
		if (a == -1) break;
		if (a == 0) q.pop();
		else {
			if(q.size()<n) q.push(a);
		}
	}
	if (q.empty()) cout << "empty";
	else {
		while (!q.empty()) {
			cout << q.front() << " ";
			q.pop();
		}
	}
	return 0;
}