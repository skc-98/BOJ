#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	cin.ignore();

	for (int i = 1; i <= n; i++) {
		int d[128] = { 0, };
		int tp = 0, dp = 0, sp = 0;
		string s;
		getline(cin, s);
		for (int j = 0; j < s.length(); j++) {
			if (s[j] >= 'A' && s[j] <= 'Z') d[s[j] - 'A' + 'a']++;
			else if (s[j] >= 'a' && s[j] <= 'z') d[s[j]]++;
		}
		for (int j = 'a'; j <= 'z'; j++) {
			if (d[j] >= 3) tp++;
			if (d[j] >= 2) dp++;
			if (d[j] >= 1) sp++;
		}

		if (tp == 26) cout << "Case " << i << ": " << "Triple pangram!!!" << '\n';
		else if (dp == 26) cout << "Case " << i << ": " << "Double pangram!!" << '\n';
		else if (sp == 26) cout << "Case " << i << ": " << "Pangram!" << '\n';
		else cout << "Case " << i << ": " << "Not a pangram" << '\n';
	}

	return 0;
}