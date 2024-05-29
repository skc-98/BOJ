#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	getline(cin, s);

	vector<string> v;
	string ss;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '<') {
			if (!ss.empty()) v.push_back(ss);
			ss = "";
			v.push_back("<");
			continue;
		}
		else if (s[i] == '>') {
			if (!ss.empty()) v.push_back(ss);
			ss = "";
			v.push_back(">");
			continue;
		}
		else if (s[i] == '&' && s[i + 1] == '&') {
			if (!ss.empty()) v.push_back(ss);
			ss = "";
			v.push_back("&&");
			i++;
			continue;
		}
		else if (s[i] == '|' && s[i + 1] == '|') {
			if (!ss.empty()) v.push_back(ss);
			ss = "";
			v.push_back("||");
			i++;
			continue;
		}
		else if (s[i] == '(') {
			if (!ss.empty()) v.push_back(ss);
			ss = "";
			v.push_back("(");
			continue;
		}
		else if (s[i] == ')') {
			if (!ss.empty()) v.push_back(ss);
			ss = "";
			v.push_back(")");
			continue;
		}
		else if (s[i] == ' ') {
			if (!ss.empty()) v.push_back(ss);
			ss = "";
			continue;
		}
		if (s[i] != ' ') ss += s[i];
	}
	if (ss != "") v.push_back(ss);

	string ans_str = "";
	for (int i = 0; i < v.size(); i++) {
		ans_str += v[i];
		if (i != v.size() - 1) ans_str += " ";
	}
	cout << ans_str;
	return 0;
}