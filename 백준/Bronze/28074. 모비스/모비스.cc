#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	if (s.find("M") == string::npos || s.find("O") == string::npos || s.find("B") == string::npos || s.find("I") == string::npos || s.find("S") == string::npos) {
		cout << "NO";
	}
	else cout << "YES";
	return 0;
}