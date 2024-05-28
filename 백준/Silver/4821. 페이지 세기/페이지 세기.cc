#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		int n;
		cin >> n;
		if (n == 0) break;
		string s;
		cin >> s;

		string ss = "";
		vector<string> v;
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == ',') {
				v.push_back(ss);
				ss = "";
				continue;
			}
			ss += s[i];
		}
		if (!ss.empty()) v.push_back(ss);

		vector<bool> pages(n + 1, 0);
		for (int i = 0; i < v.size(); i++) {
			string sss = "";
			vector<string> v2;
			for (int j = 0; j < v[i].length(); j++) {
				if (v[i][j] == '-') {
					v2.push_back(sss);
					sss = "";
					continue;
				}
				sss += v[i][j];
			}
			if (!sss.empty()) v2.push_back(sss);

			if (v2.size() == 1) {
				if (stoi(v2[0]) <= n) {
					pages[stoi(v2[0])] = true;
				}
			}
			if (v2.size() == 2) {
				int start = stoi(v2[0]);
				int end = stoi(v2[1]);
				if (start > n) continue;
				if (end > n) end = n;
				for (int k = start; k <= end; k++) {
					pages[k] = true;
				}
			}
		}
		int count = 0;
		for (int i = 1; i <= n; i++) if (pages[i]) count++;
		cout << count << '\n';
	}

	return 0;
}