#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		string s1, s2;
		cin >> s1 >> s2;
		
		int  ans = 0;
		for (int j = 0; j < s1.length(); j++) {
			if (s1.substr(j, s2.length()) == s2) {
				j += s2.length() - 1;
				ans++;
			}
			else {
				ans++;
			}
		}
		cout << ans << '\n';
	}

	return 0;
}