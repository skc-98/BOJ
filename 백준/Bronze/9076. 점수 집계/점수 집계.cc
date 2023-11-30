#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int tc;
	cin >> tc;
	for (int i = 1; i <= tc; i++) {
		vector<int> v;
		for (int j = 1; j <= 5; j++) {
			int a;
			cin >> a;
			v.push_back(a);
		}
		sort(v.begin(), v.end());
		int max = 0;
		int min = 999;
		int sum = 0;
		for (int j = 1; j <= 3; j++) {
			if (v[j] > max) max = v[j];
			if (v[j] < min) min = v[j];
			sum += v[j];
		}
		if (max - min >= 4) {
			cout << "KIN" << '\n';
		}
		else cout << sum << '\n';
	}

	return 0;
}