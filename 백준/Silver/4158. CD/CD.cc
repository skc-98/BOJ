#include<iostream>
#include<vector>
using namespace std;

int bs(const vector<int>& v, int key) {
	int start = 0;
	int end = v.size() - 1;
	while (1) {
		if (start > end) return 0;
		int mid = (start + end) / 2;
		if (v[mid] == key) return 1;
		else if (v[mid] > key) {
			end = mid - 1;
		}
		else start = mid + 1;
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		int n, m;
		cin >> n >> m;
		if (n == 0 && m == 0) break;

		vector<int> v;
		for (int i = 1; i <= n; i++) {
			int a;
			cin >> a;
			v.push_back(a);
		}

		int ans = 0;
		for (int i = 1; i <= m; i++) {
			int a;
			cin >> a;
			ans += bs(v, a);
		}
		cout << ans << '\n';
	}
	return 0;
}