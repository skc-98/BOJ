#include<iostream>
#include<vector>
#include<string>
#include<sstream>
#include<algorithm>
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
	cin.ignore();

	for (int i = 1; i <= tc; i++) {
		vector<int> v;
		string s;
		getline(cin, s);
		stringstream ss(s);

		int num;
		while (ss >> num) {
			v.push_back(num);
		}

		int max = 0;
		for (int j = 0; j < v.size() - 1; j++) {
			for (int k = j + 1; k < v.size(); k++) {
				if (j == k) continue;
				int a = gcd(v[j], v[k]);
				if (max < a) max = a;
			}
		}
		cout << max << '\n';
	}
	return 0;
}