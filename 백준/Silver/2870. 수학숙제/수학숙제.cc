#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const string& a, const string& b) {
	if (a.length() != b.length()) return a.length() < b.length();
	return a < b;
}

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
		string a = "";
		for (int j = 0; j < s.length(); j++) {
			if (s[j] >= '0' && s[j] <= '9') {
				a += s[j];
			}
			else {
				if (a != "") {
					v.push_back(a);
					a = "";
				}
			}
		}
		if (a != "") {
			v.push_back(a);
		}
	}

	vector<string> v2;
	for (int i = 0; i < v.size(); i++) {
		string t = "";
		int start = 0;
		for (int j = 0; j < v[i].length(); j++) {
			if (start == 0 && v[i][j] == '0') {
				start = 0;
				continue;
			}
			else start = 1;
			if (start == 1) t += v[i][j];
		}
		if (t == "") v2.push_back("0");
		else v2.push_back(t);
	}
	sort(v2.begin(), v2.end(), cmp);
	for (int i = 0; i < v2.size(); i++) {
		cout << v2[i] << '\n';
	}
	return 0;
}