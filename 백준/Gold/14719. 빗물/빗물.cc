#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v;
	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}

	int ans = 0;
	for (int i = 0; i < v.size(); i++) {
		int leftmax = 0;
		int rightmax = 0;
		for (int j = i; j >= 0; j--) {
			if (leftmax < v[j]) leftmax = v[j];
		}
		for (int j = i; j < v.size(); j++) {
			if (rightmax < v[j]) rightmax = v[j];
		}
		int high = min(leftmax, rightmax);
		if (high - v[i] > 0) ans += high - v[i];
	}
	cout << ans;
	return 0;
}