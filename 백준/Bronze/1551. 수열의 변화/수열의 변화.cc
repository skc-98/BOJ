#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	string s;
	cin >> s;

	vector<int> v;
	string ss = "";
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == ',') {
			v.push_back(stoi(ss));
			ss = "";
			continue;
		}
		ss += s[i];
	}
	if (ss != "") v.push_back(stoi(ss));

	vector<int> v2;
	for (int j = 0; j < m; j++) {
		for (int i = 0; i < v.size() - 1; i++) {
			v2.push_back(v[i + 1] - v[i]);
		}
		v = v2;
		v2.clear();
	}
	string ans = "";
	for (int i = 0; i < v.size(); i++) {
		ans += to_string(v[i]);
		if (i != v.size() - 1)ans += ",";
	}
	cout << ans;
	return 0;
}