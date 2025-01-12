#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	string ans = "";
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'E') ans += 'I';
		else if (s[i] == 'S') ans += 'N';
		else if (s[i] == 'T') ans += 'F';
		else if (s[i] == 'J') ans += 'P';
		else if (s[i] == 'I') ans += 'E';
		else if (s[i] == 'N') ans += 'S';
		else if (s[i] == 'F') ans += 'T';
		else if (s[i] == 'P') ans += 'J';
	}
	cout << ans;
	return 0;
}