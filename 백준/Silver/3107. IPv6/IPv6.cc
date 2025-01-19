#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	string ans = "";
	string ss = "";
	vector<string> v;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == ':') {
			if (ss != "") {
				v.push_back(ss);
				ss = "";
			}
			if (i + 1 < s.length() && s[i + 1] == ':') {
				v.push_back("");
				i++;
			}
		}
		else {
			ss += s[i];
		}
	}
	if (ss != "") v.push_back(ss);

	for (int i = 0; i < v.size(); i++) {
		if (v[i] == "") {
			for (int j = 0; j <= 8 - v.size(); j++) {
				ans += "0000";
				ans += ":";
			}
		}
		else {
			for (int j = 0; j < 4 - v[i].length(); j++) {
				ans += '0';
			}
			ans += v[i];
			ans += ":";
		}
	}
	if (ans[ans.length() - 1] == ':') ans.pop_back();
	cout << ans;
	return 0;
}