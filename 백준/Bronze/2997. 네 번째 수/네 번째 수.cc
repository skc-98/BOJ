#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	vector<int> v;
	for (int i = 0; i < 3; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	if (abs(v[0] - v[1]) == abs(v[1] - v[2])) {
		cout << v[2] + abs(v[1] - v[2]);
	}
	else {
		int n = v[1] - v[0];
		if (v[2] - v[1] > n) {
			cout << v[1] + n;
		}
		else {
			cout << v[0] + (v[2] - v[1]);
		}
	}

	return 0;
}