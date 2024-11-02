#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, k;
	cin >> n >> k;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	int ans = 0;
	int left = 0, right = n - 1;
	while (1) {
		if (left >= right) break;
		if (v[right] > k) {
			right--;
			continue;
		}
		if (v[right] + v[left] <= k) {
			ans++;
			left++;
			right--;
		}
		else if (v[right] + v[left] > k) right--;
	}
	cout << ans;
	return 0;
}