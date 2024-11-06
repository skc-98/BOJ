#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		int n;
		cin >> n;
		if (n == 0) break;

		int zcount = 0;
		vector<int> v(n);
		for (int i = 0; i < n; i++) {
			cin >> v[i];
			if (v[i] == 0) zcount++;
		}
		sort(v.begin(), v.end());
		if (zcount == 1) swap(v[0], v[2]);
		else if (zcount > 1) {
			swap(v[0], v[zcount]);
			swap(v[1], v[zcount + 1]);
		}

		bool check = 0;
		string s1 = "", s2 = "";
		for (int i = 0; i < n; i++) {
			if (!check) s1 += to_string(v[i]);
			else s2 += to_string(v[i]);
			check = !check;
		}
		int ans = stoi(s1) + stoi(s2);
		cout << ans << '\n';
	}

	return 0;
}