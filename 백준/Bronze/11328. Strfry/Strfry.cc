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
		string s, s2;
		int d[500] = { 0, };
		int d2[500] = { 0, };
		cin >> s >> s2;
		if (s.length() != s2.length()) {
			cout << "Impossible" << '\n';
			continue;
		}
		for (int j = 0; j < s.length(); j++) {
			d[s[j]]++;
			d2[s2[j]]++;
		}
		bool check = 0;
		for (int j = 'a'; j <= 'z'; j++) {
			if (d[j] != d2[j]) {
				check = 1;
				break;
			}
		}
		if (check == 0) {
			cout << "Possible" << '\n';
		}
		else {
			cout << "Impossible" << '\n';
		}
	}

	return 0;
}