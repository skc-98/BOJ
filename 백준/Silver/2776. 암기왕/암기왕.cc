#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int bs(const vector<int>& v, int key) {
	int start = 0, end = v.size() - 1;
	int mid;
	while (1) {
		if (start > end) break;
		mid = (start + end) / 2;
		if (v[mid] == key) return 1;
		else if (v[mid] > key) end = mid - 1;
		else start = mid + 1;
	}
	return 0;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;
	for (int i = 1; i <= tc; i++) {
		int n1;
		cin >> n1;
		vector<int> note1;
		for (int j = 1; j <= n1; j++) {
			int n; cin >> n; note1.push_back(n);
		}
		sort(note1.begin(), note1.end());

		int n2;
		cin >> n2;
		for (int j = 1; j <= n2; j++) {
			int n;
			cin >> n;
			int ans = bs(note1, n);
			cout << ans << '\n';
		}
	}
	return 0;
}