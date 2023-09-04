#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v;
	for (int i = 1; i <= n; i++) {
		int a; cin >> a;
		v.push_back(a);
	}

	vector<int> v2;
	for (int i = 1; i <= m; i++) {
		int a; cin >> a;
		v2.push_back(a);
	}

	int count = 0;
	for (int i = 0; i < m; i++) {
		int check = 0;
		for (int j = 0; j < v2.size(); j++) {
			if (v[i] == v2[j]) check = 1;
		}
		if (check == 0) count++;
	}

	cout << count;
	return 0;
}