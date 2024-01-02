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
	
	vector<int> v;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	reverse(v.begin(), v.end());

	int ans = 0;
	for (int i = 1; i < v.size(); i++) {
		if (v[i] >= v[i - 1]) {
			while (1) {
				v[i]--;
				ans++;
				if (v[i] < v[i - 1]) break;
			}
		}
	}
	cout << ans;
	return 0;
}