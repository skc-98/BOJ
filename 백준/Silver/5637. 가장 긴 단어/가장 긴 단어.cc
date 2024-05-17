#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string max = "";
	while (1) {
		string s;
		cin >> s;
		if (s == "E-N-D") break;

		string ss="";
		for (int i = 0; i < s.length(); i++) {
			if ((s[i] >= 'a' && s[i] <= 'z') || s[i]=='-') {
				ss += s[i];
			}
			else if ((s[i] >= 'A' && s[i] <= 'Z') || s[i]=='-') {
				ss += tolower(s[i]);
			}
		}
		if (ss.length() > max.length()) max = ss;
	}
	cout << max;
	return 0;
}