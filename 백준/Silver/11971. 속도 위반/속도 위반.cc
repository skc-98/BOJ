#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	int length = 0;
	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		for (int j = 0; j < a; j++) {
			v.push_back(b);
		}
		length += a;
	}

	vector<int> v2;
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		for (int j = 0; j < a; j++) {
			v2.push_back(b);
		}
	}

	int max = 0;
	for (int i = 0; i < length; i++) {
		if (max < (v2[i] - v[i])) {
			max = v2[i] - v[i];
		}
	}
	cout << max;
	return 0;
}