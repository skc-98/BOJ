#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
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
	sort(v.begin(), v.end());

	int l = 0, r = n - 1;
	int al = 0, ar = 0;
	long long minsum = 999999999999;
	while (l < r) {
		int sum = abs(v[l] + v[r]);
		if (sum < minsum) {
			minsum = sum;
			al = v[l];
			ar = v[r];
		}
		if (v[l] + v[r] < 0) l++;
		else if (v[l] + v[r] > 0) r--;
		else break;
	}
	cout << al << " " << ar;
	return 0;
}