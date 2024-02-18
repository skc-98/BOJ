#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int sum = 0;
	vector<int> v;
	for (int i = 0; i < 9; i++) {
		int a;
		cin >> a;
		v.push_back(a);
		sum += a;
	}

	int n, m;
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (i != j && sum - v[i] - v[j] == 100) {
				n = i; m = j;
			}
		}
	}

	vector<int> ans;
	for (int i = 0; i < 9; i++) {
		if (i != n && i != m) ans.push_back(v[i]);
	}

	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i] << '\n';
	}
	return 0;
}