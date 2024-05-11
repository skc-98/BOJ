#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int t = 0; t < tc; t++) {
		int n;
		cin >> n;

		long long profit = 0;
		vector<int> v;
		for (int i = 0; i < n; i++) {
			int a;
			cin >> a;
			v.push_back(a);
		}

		long long max = 0;
		for (int i = v.size() - 1; i >= 0; i--) {
			if (v[i] > max) {
				max = v[i];
				continue;
			}
			else {
				profit += (max - v[i]);
			}
		}

		cout << profit << '\n';
	}
	return 0;
}