#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	priority_queue<int> present;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		present.push(a);
	}

	vector<int> kid;
	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		kid.push_back(a);
	}

	for (int i = 0; i < kid.size(); i++) {
		if (kid[i] > present.top()) {
			cout << 0;
			return 0;
		}
		else {
			int less = present.top() - kid[i];
			if (less == 0) {
				present.pop();
			}
			else {
				present.pop();
				present.push(less);
			}
		}
	}
	cout << 1;
	return 0;
}