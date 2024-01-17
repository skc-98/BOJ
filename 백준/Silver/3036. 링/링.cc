#include<iostream>
#include<vector>
#include<numeric>
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

	int p = v[0];
	for (int i = 1; i < v.size(); i++) {
		int g = gcd(p, v[i]);
		cout << p / g << "/" << v[i] / g << '\n';
	}

	return 0;
}