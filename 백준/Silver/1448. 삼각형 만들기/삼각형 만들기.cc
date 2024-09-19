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

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	for (int i = n - 3; i >= 0; i--) {
		if (v[i + 2] < v[i + 1] + v[i]) {
			cout << v[i + 2] + v[i + 1] + v[i];
			return 0;
		}
	}
	cout << -1;
	return 0;
}