#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string str;
	getline(cin, str);

	for (int i = 0; i < str.length(); i++) {
		if (str[i] >= 'A' && str[i] <= 'Z') {
			str[i] += 13;
			if (str[i] >= 91) str[i] -= 26;
		}
		else if (str[i] >= 'a' && str[i] <= 'z') {
			str[i] += 13;
			if (str[i] >= 123 || str[i] < 0) str[i] -= 26;
		}
	}
	cout << str;
	return 0;
}