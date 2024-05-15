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

		vector<string> v;
		string a = "";
		for (int j = 0; j < s.length(); j++) {
			if (s[j] == ' ') {
				v.push_back(a);
				a = "";
			}
			else a += s[j];
		}
		v.push_back(a);

		cout << "Case #" << i + 1 << ": ";
		for (int j = v.size() - 1; j >= 0; j--) cout << v[j] << " ";
		cout << '\n';
	}

	return 0;
}