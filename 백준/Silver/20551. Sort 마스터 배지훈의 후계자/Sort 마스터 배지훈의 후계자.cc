#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int bs(const vector<int>& v, int key) {
	int start = 0;
	int end = v.size() - 1;
	int result = -1;
	while (start <= end) {
		int mid = (start + end) / 2;
		if (v[mid] == key) {
			result = mid;
			end = mid - 1;
		}
		else if (v[mid] < key) start = mid + 1;
		else end = mid - 1;
	}
	return result;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		int ans = bs(v, a);
		cout << ans << '\n';
	}

	return 0;
}