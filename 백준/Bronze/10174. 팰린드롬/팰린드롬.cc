#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	cin.ignore();
	for (int i = 0; i < n; i++) {
		string s;
		getline(cin, s);
		int p1 = 0;
		int p2 = s.length() - 1;
		while (1) {
			if (s[p1] >= 'A' && s[p1] <= 'Z') {
				s[p1] += 32;
			}
			if (s[p2] >= 'A' && s[p2] <= 'Z') {
				s[p2] += 32;
			}
			if (p1 >= p2) {
				cout << "Yes" << '\n';
				break;
			}
			if (s[p1] == s[p2]) {
				p1++;
				p2--;
			}
			else {
				cout << "No" << '\n';
				break;
			}
		}
	}

	return 0;
}