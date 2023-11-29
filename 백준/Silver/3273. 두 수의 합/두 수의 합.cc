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

	vector<int> v(n+1);
	for (int i = 1; i <= n; i++) {
		cin >> v[i];
	}

	int num;
	cin >> num;

	sort(v.begin(), v.end());
	int p1 = 1;
	int p2 = n;
	int ans = 0;
	while (1) {
		if (p1 >= p2) break;
		if (v[p1] + v[p2] == num) {
			ans++;
			p1++;
			p2--;
		}
		else if (v[p1] + v[p2] < num) p1++;
		else p2--;
	}
	cout << ans;
	return 0;
}