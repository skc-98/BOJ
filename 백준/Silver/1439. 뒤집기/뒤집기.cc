#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;
	
	int z = 0;
	int o = 0;
	if (s[0] == '0') z++;
	else o++;

	char now = s[0];
	for (int i = 1; i < s.length(); i++) {
		if (s[i] != now) {
			if (s[i] == '0') z++;
			else o++;
			now = s[i];
		}
	}
	if (z > o) cout << o;
	else cout << z;
	return 0;
}