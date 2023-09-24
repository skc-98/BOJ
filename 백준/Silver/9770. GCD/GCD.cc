#include<iostream>
#include<vector>
using namespace std;

int gcd(int n, int m) {
	if (m == 0) return n;
	return gcd(m, n % m);
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	vector<int> v;
	int n;
	while (cin >> n) {
		v.push_back(n);
	}

	int max = 0;
	for (int i = 0; i < v.size() - 1; i++) {
		for (int j = i + 1; j < v.size(); j++) {
			if (gcd(v[i], v[j]) > max) max = gcd(v[i], v[j]);
		}
	}
	cout << max;
	return 0;
}