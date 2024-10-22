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

	int ans = 0;
	for (int i = 0; i < n; i++) {
		int left = 0, right = n - 1;
		while (left < right) {
			if (left == i) {
				left++;
				continue;
			}
			if (right == i) {
				right--;
				continue;
			}
			int sum = v[left] + v[right];
			if (sum == v[i]) {
				ans++;
				break;
			}
			if (sum < v[i]) left++;
			else right--;
		}
	}
	cout << ans;
	return 0;
}