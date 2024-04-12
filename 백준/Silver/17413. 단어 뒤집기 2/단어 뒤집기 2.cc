#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	getline(cin, s);

	string answer = "";
	string ss = "";
	bool check = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '<') {
			if (ss != "") {
				reverse(ss.begin(), ss.end());
				answer += ss;
				ss = "";
			}
			answer += s[i];
			check = 1;
			continue;
		}
		if (s[i] == '>') {
			answer += s[i];
			check = 0;
			continue;
		}
		if (check == 1) {
			answer += s[i];
			continue;
		}
		if (s[i] != ' ') {
			ss += s[i];
		}
		if (s[i] == ' ') {
			reverse(ss.begin(), ss.end());
			answer += ss;
			answer += " ";
			ss = "";
		}
	}
	if (ss != "") {
		reverse(ss.begin(), ss.end());
		answer += ss;
		answer += " ";
	}
	cout << answer;
	return 0;
}