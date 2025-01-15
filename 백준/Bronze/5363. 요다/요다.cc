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
		string ss = "";
		int cnt = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s[j] == ' ') {
				cnt++;
				if (cnt == 2) {
					for (int k = j + 1; k < s.length(); k++) cout << s[k];
					break;
				}
			}
			ss += s[j];
		}
		cout << " " << ss << '\n';
	}
	return 0;
}