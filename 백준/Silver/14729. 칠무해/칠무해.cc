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

	vector<double> v;
	for (int i = 1; i <= n; i++) {
		double a;
		cin >> a;
		v.push_back(a);
	}

	sort(v.begin(), v.end());
	for (int i = 0; i < 7; i++) {
		cout << fixed;
		cout.precision(3);
		cout << v[i] << '\n';
	}

	return 0;
}