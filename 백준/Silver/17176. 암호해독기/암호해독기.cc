#include<iostream>
#include<string>
using namespace std;

int d[53];
int e[53];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		d[a]++;
	}

	string s;
	cin.ignore();
	getline(cin, s);
	for (int i = 0; i < s.length(); i++) {
		if (s[i] >= 'a' && s[i] <= 'z') {
			e[s[i] - 70]++;
		}
		else if (s[i] >= 'A' && s[i] <= 'Z') {
			e[s[i] - 64]++;
		}
		else e[0]++;
	}

	bool check = 0;
	for (int i = 1; i < 53; i++) {
		if (d[i] != e[i]) {
			check = 1;
			break;
		}
	}
	if (check == 0) cout << "y";
	else cout << "n";

	return 0;
}