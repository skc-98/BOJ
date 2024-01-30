#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	if (s.find("K") != string::npos && s.find("O") != string::npos && s.find("R") != string::npos && s.find("E") != string::npos && s.find("A") != string::npos) {
		cout << "KOREA";
	}
	else if (s.find("Y") != string::npos && s.find("O") != string::npos && s.find("N") != string::npos && s.find("S") != string::npos && s.find("E") != string::npos && s.find("I") != string::npos) {
		cout << "YONSEI";
	}
	return 0;
}