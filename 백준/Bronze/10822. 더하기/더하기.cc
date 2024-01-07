#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	int sum = 0;
	string a;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == ',') {
			sum += stoi(a);
			a = "";
		}
		else a += s[i];
	}
	sum += stoi(a);
	cout << sum;
	return 0;
}