#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int bs(const vector<int>& v, int key) {
	int start = 0;
	int end = v.size() - 1;
	while (1) {
		int mid = (start + end) / 2;
		if (start > end) break;
		if (v[mid] == key) return mid + 1;
		if (v[mid] > key) end = mid - 1;
		else start = mid + 1;
	}
	return 0;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> a;
	for (int i = 1; i <= n; i++) {
		int num;
		cin >> num;
		a.push_back(num);
	}

	vector<int> b;
	for (int i = 1; i <= m; i++) {
		int num;
		cin >> num;
		b.push_back(num);
	}
	sort(a.begin(), a.end());
	sort(b.begin(), b.end());

	vector<int> ans;
	for (int i = 0; i < a.size(); i++) {
		int t=bs(b, a[i]);
		if (t == 0) ans.push_back(t);
	}
	for (int i = 0; i < b.size(); i++) {
		int t = bs(a, b[i]);
		if (t == 0) ans.push_back(t);
	}

	cout << ans.size();
	return 0;
}