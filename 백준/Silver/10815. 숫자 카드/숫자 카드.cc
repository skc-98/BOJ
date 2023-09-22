#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int bsearch(const vector<int>& v, int key, int start, int end) {
	if (start > end) return 0;
	int mid = (start + end) / 2;
	if (v[mid] == key) return 1;
	else if (v[mid] > key) {
		end = mid - 1;
		return bsearch(v, key, start, end);
	}
	else {
		start = mid + 1;
		return bsearch(v, key, start, end);
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int n;
	cin >> n;
	vector<int> v;
	for (int i = 1; i <= n; i++) {
		int a; cin >> a; v.push_back(a);
	}
	sort(v.begin(), v.end());

	int m;
	cin >> m;
	vector<int> v2;
	for (int i = 1; i <= m; i++) {
		int a; cin >> a; v2.push_back(a);
	}

	for (int i = 0; i < v2.size(); i++) {
		int ans = bsearch(v, v2[i], 0, n - 1);
		cout << ans << " ";
	}
	return 0;
}