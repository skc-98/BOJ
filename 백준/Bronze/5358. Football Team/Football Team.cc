#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	while (getline(cin, s)) {
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == 'e') s[i] = 'i';
			else if (s[i] == 'i') s[i] = 'e';
			else if (s[i] == 'E') s[i] = 'I';
			else if (s[i] == 'I') s[i] = 'E';
		}
		cout << s << '\n';
	}

	return 0;
}