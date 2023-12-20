#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> trick;
	int winner = 0;
	for (int i = 0; i < n; i++) {
		int point = 0;
		int a, b;
		cin >> a >> b;
		if (a >= b) point += a;
		else point += b;
		for (int j = 1; j <= 5; j++) {
			int a;
			cin >> a;
			trick.push_back(a);
		}
		sort(trick.begin(), trick.end());
		point += trick[3];
		point += trick[4];
		if (point > winner) winner = point;
		trick.clear();
	}
	cout << winner;
	return 0;
}