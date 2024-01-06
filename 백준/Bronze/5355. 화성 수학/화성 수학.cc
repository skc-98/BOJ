#include<iostream>
#include<string>
#include<sstream>
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
		stringstream ss(s);
		string word;
		vector<string> v;
		while (ss >> word) {
			v.push_back(word);
		}
		double ans = stod(v[0]);
		for (int j = 1; j < v.size(); j++) {
			if (v[j] == "@") ans *= 3;
			else if (v[j] == "%") ans += 5;
			else if (v[j] == "#") ans -= 7;
		}
		cout << fixed;
		cout.precision(2);
		cout << ans << '\n';
	}

	return 0;
}