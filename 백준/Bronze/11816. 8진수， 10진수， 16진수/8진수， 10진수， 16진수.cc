#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;
	
	string check;
	if (s[0] == '0' && s[1] == 'x') check = "hex";
	else if (s[0] == '0') check = "oct";
	else check = "dec";

	if (check == "dec") cout << s;
	else if (check == "oct") {
		int ans = 0;
		for (int i = 1; i < s.length(); i++) {
			ans = ans * 8 + (s[i] - '0');
		}
		cout << ans;
	}
	else if (check == "hex") {
		int ans = 0;
		for (int i = 2; i < s.length(); i++) {
			if (s[i] >= '0' && s[i] <= '9') {
				ans = ans * 16 + (s[i] - '0');
			}
			else if (s[i] >= 'a' && s[i] <= 'f') {
				ans = ans * 16 + (s[i] - 'a' + 10);
			}
			else if (s[i] >= 'A' && s[i] <= 'F') {
				ans = ans * 16 + (s[i] - 'A' + 10);
			}
		}
		cout << ans;
	}
	return 0;
}