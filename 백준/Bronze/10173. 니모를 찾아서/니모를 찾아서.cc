#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		string s;
		bool check = 0;
		getline(cin, s);
		if (s == "EOI") break;
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == 'N' || s[i] == 'n') {
				if (s[i + 1] == 'E' || s[i + 1] == 'e') {
					if (s[i + 2] == 'M' || s[i + 2] == 'm') {
						if (s[i + 3] == 'O' || s[i + 3] == 'o') {
							check = 1;
						}
					}
				}
			}
		}
		if (check) cout << "Found" << '\n';
		else cout << "Missing" << '\n';
	}

	return 0;
}