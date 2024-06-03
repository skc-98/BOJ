#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, score, p;
	cin >> n >> score >> p;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end(), greater<int>());

	if (n == p && score <= v[n - 1]) {
		cout << -1;
		return 0;
	}

	int count = 1;
	for (int i = 0; i < n; i++) {
		if (v[i] > score) count++;
		else break;
	}
	cout << count;
	return 0;
}