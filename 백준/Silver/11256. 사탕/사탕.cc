#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(int a, int b) {
	return a > b;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 1; i <= tc; i++) {
		vector<int> v;
		int n, m;
		cin >> n >> m;
		for (int j = 1; j <= m; j++) {
			int a, b;
			cin >> a >> b;
			v.push_back(a * b);
		}
		sort(v.begin(), v.end(), cmp);

		int count = 0;
		for (int j = 0; j < v.size(); j++) {
			n -= v[j];
			count++;
			if (n <= 0) break;
		}
		cout << count << '\n';
	}

	return 0;
}