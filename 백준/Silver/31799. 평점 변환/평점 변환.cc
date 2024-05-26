#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	string s;
	cin >> s;

	vector<string> v;
	string ss = "";
	for (int i = 0; i < s.length(); i++) {
		if (ss != "" && (s[i] >= 'A' && s[i] <= 'Z')) {
			v.push_back(ss);
			ss = "";
		}
		ss += s[i];
	}
	v.push_back(ss);

	for (int i = 0; i < v.size(); i++) {
		if (v[i] == "A" || v[i] == "B" || v[i] == "C") v[i] += "0";
	}

	string ans = "";
	for (int i = 0; i < v.size(); i++) {
		if (v[i] == "A+") ans += "E";
		else if (v[i] == "A0") {
			if (i == 0 || v[i - 1] == "A-" || v[i - 1] == "B+" || v[i - 1] == "B0" || v[i - 1] == "B-" || v[i - 1] == "C+" || v[i - 1] == "C0" || v[i - 1] == "C-") ans += "E";
			else if (v[i - 1] == "A+" || v[i - 1] == "A0") ans += "P";
		}
		else if (v[i] == "A-" || v[i] == "B+") {
			if (i == 0 || v[i - 1] == "B0" || v[i - 1] == "B-" || v[i - 1] == "C+" || v[i - 1] == "C0" || v[i - 1] == "C-") ans += "P";
			else if (v[i - 1] == "A+" || v[i - 1] == "A0" || v[i - 1] == "A-" || v[i - 1] == "B+") ans += "D";
		}
		else if (v[i] == "B0" || v[i] == "B-") {
			if (i == 0 || v[i - 1] == "C+" || v[i - 1] == "C0" || v[i - 1] == "C-") ans += "D";
			else if (v[i - 1] == "A+" || v[i - 1] == "A0" || v[i - 1] == "A-" || v[i - 1] == "B+" || v[i - 1] == "B0" || v[i - 1] == "B-") ans += "B";
		}
		else if (v[i] == "C+" || v[i] == "C0" || v[i] == "C-") ans += "B";
	}

	cout << ans;
	return 0;
}