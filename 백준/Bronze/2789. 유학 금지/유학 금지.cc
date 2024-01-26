#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	string s2 = "";
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'C' || s[i] == 'A' || s[i] == 'M' || s[i] == 'B' || s[i] == 'R' || s[i] == 'I' || s[i] == 'D' || s[i] == 'G' || s[i] == 'E') continue;
		s2 += s[i];
	}
	cout << s2;
	return 0;
}