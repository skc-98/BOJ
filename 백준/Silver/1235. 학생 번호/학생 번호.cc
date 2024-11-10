#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<string> v;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		v.push_back(s);
	}

	int ans = 1;
	bool check = 0;
	while (1) {
		if (check == 1) break;
		vector<string> v2;
		for (int i = 0; i < n; i++) {
			string s = "";
			int len = v[i].size();
			for (int j = len - 1; j >= max(0, len - ans); j--) {
				s += v[i][j];
			}
			v2.push_back(s);
		}
		check = 1;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (v2[i] == v2[j]) {
					check = 0;
					break;
				}
			}
		}
		if (!check) ans++;
	}
	cout << ans;
	return 0;
}