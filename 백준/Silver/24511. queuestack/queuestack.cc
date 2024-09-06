#include<iostream>
#include<vector>
#include<deque>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int n;
	cin >> n;

	vector<bool> check;
	for (int i = 0; i < n; i++) {
		bool a;
		cin >> a;
		check.push_back(a);
	}

	deque<int> dq;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (check[i] == 0) dq.push_back(a);
	}

	int m;
	cin >> m;
	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		dq.push_front(a);
		cout << dq.back() << " ";
		dq.pop_back();
	}
	return 0;
}