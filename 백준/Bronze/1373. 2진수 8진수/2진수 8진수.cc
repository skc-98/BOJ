#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	while (s.length() % 3 != 0) {
		s = "0" + s;
	}

	string oc;
	for (int i = 0; i < s.length(); i += 3) {
		string s2 = s.substr(i, 3);
		int n = stoi(s2, nullptr, 2);
		oc += to_string(n);
	}
	cout << oc;
	return 0;
}