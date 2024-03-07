#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	string answer = "";
	bool cpp = 0;
	bool java = 0;
	if (s[s.length() - 1] == '_') {
		cout << "Error!";
		return 0;
	}

	if (s[0] == '_') {
		cout << "Error!";
		return 0;
	}

	if (s[0] >= 'A' && s[0] <= 'Z') {
		cout << "Error!";
		return 0;
	}

	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '_' && s[i + 1] == '_') {
			cout << "Error!";
			return 0;
		}
	}

	if (s.find('_') != string::npos) cpp = 1;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] >= 'A' && s[i] <= 'Z') {
			java = 1;
			break;
		}
	}

	if (cpp == 1 && java == 1) {
		cout << "Error!";
		return 0;
	}
	
	if (cpp == true) {
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == '_') {
				answer += s[i + 1] - 32;
				i++;
				continue;
			}
			answer += s[i];
		}
	}
	else {
		for (int i = 0; i < s.length(); i++) {
			if (s[i] >= 'A' && s[i] <= 'Z') {
				answer += '_';
				answer += s[i] + 32;
				continue;
			}
			answer += s[i];
		}
	}
	cout << answer;
	return 0;
}