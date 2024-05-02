#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	vector<string> v;
	string ss="";
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '+') {
			v.push_back(ss);
			v.push_back("+");
			ss = "";
			continue;
		}
		else if (s[i] == '-') {
			v.push_back(ss);
			v.push_back("-");
			ss = "";
			continue;
		}
		ss += s[i];
	}
	v.push_back(ss);
	
	int ans = 0;
	bool check = 0;
	ans += stoi(v[0]);
	for (int i = 1; i < v.size(); i++) {
		if (v[i] == "+" && check == 0) {
			ans += stoi(v[i + 1]);
		}
		else if (v[i] == "+" && check == 1) {
			ans -= stoi(v[i + 1]);
		}
		else if (v[i] == "-") {
			ans -= stoi(v[i + 1]);
			check = 1;
		}
	}
	cout << ans;
	return 0;
}