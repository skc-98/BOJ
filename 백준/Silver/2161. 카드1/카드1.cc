#include<iostream>
#include<deque>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int n;
	cin >> n;
	deque<int> dq;
	for (int i = 1; i <= n; i++) dq.push_back(i);
	while (1) {
		if (dq.empty() == true) break;
		cout << dq.front() << " ";
		dq.pop_front();
		if (dq.empty() == true) break;
		int a = dq.front();
		dq.pop_front();
		dq.push_back(a);
	}

	return 0;
}