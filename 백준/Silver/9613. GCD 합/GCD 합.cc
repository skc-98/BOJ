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

	int tc;
	cin >> tc;

	for (int i = 1; i <= tc; i++) {
		vector<int> v;
		int n;
		cin >> n;
		for (int j = 1; j <= n; j++) {
			int a; cin >> a;
			v.push_back(a);
		}
		long long sum = 0;
		for (int j = 0; j < v.size() - 1; j++) {
			for (int k = j + 1; k < v.size(); k++) {
				sum += gcd(v[j], v[k]);
			}
		}
		cout << sum << '\n';
	}
	return 0;
}