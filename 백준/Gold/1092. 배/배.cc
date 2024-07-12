#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	int m;
	cin >> m;
	vector<int> v2;
	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		v2.push_back(a);
	}

	sort(v.begin(), v.end());
	sort(v2.begin(), v2.end());

	if (v[n - 1] < v2[m - 1]) {
		cout << -1;
		return 0;
	}

	int count = 0;
	while (!v2.empty()) {
		count++;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = v2.size() - 1; j >= 0; j--) {
				if (v[i] >= v2[j]) {
					v2.erase(v2.begin() + j);
					break;
				}
			}
			if (v2.empty()) break;
		}
	}
	cout << count;
	return 0;
}