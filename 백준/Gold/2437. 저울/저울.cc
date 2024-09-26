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
	for (int i = 0; i < n; i++) cin >> v[i];
	sort(v.begin(), v.end());

	int max = v[0];
	if (max != 1) {
		cout << 1;
		return 0;
	}
	for (int i = 1; i < n; i++) {
		if (v[i] - 1 <= max) max += v[i];
		else {
			cout << max + 1;
			return 0;
		}
	}
	cout << max + 1;
	return 0;
}