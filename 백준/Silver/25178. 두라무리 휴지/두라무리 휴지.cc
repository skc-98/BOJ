#include<iostream>
#include<string>
using namespace std;

int d[130];
int d2[130];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	string s, s2;
	cin >> s >> s2;

	if (s[0] != s2[0]) {
		cout << "NO";
		return 0;
	}

	if (s[s.length() - 1] != s2[s2.length() - 1]) {
		cout << "NO";
		return 0;
	}

	string ns = "", ns2 = "";
	for (int i = 0; i < s.length(); i++) {
		d[s[i]]++;
		d2[s2[i]]++;
		if (s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u') {
			ns += s[i];
		}
		if (s2[i] != 'a' && s2[i] != 'e' && s2[i] != 'i' && s2[i] != 'o' && s2[i] != 'u') {
			ns2 += s2[i];
		}
	}

	if (ns != ns2) {
		cout << "NO";
		return 0;
	}

	bool check = 0;
	for (int i = 'a'; i < 'z'; i++) {
		if (d[i] != d2[i]) {
			check = 1;
			break;
		}
	}

	if (check) {
		cout << "NO";
		return 0;
	}
	cout << "YES";
	return 0;
}