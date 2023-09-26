#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

int bs(const vector<string>& v, string key) {
	int start = 0;
	int end = v.size() - 1;
	while (1) {
		if (start > end) return 0;
		int mid = (start + end) / 2;
		if (v[mid] == key) return 1;
		else if (v[mid] > key) end = mid - 1;
		else start = mid + 1;
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<string> v;
	for (int i = 1; i <= n; i++) {
		string a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	int count = 0;
	for (int i = 1; i <= m; i++) {
		string a;
		cin >> a;
		count += bs(v, a);
	}
	cout << count;
	return 0;
}