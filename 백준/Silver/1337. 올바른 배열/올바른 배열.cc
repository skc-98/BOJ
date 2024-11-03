#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	sort(v.begin(), v.end());

	int max = 1;
	for (int i = 0; i < n; i++) {
		int cnt = 1;
		for (int j = 1; j < 5; j++) {
			if (i + j < n && v[i + j] - v[i] < 5) cnt++;
		}
		if (cnt > max) max = cnt;
	}
	if (max >= 5) cout << 0;
	else cout << 5 - max;
	return 0;
}