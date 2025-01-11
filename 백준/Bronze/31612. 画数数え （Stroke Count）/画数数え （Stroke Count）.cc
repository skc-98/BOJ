#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	string s;
	cin >> n;
	cin >> s;

	int sum = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'j') sum += 2;
		else if (s[i] == 'o') sum += 1;
		else if (s[i] == 'i') sum += 2;
	}
	cout << sum;
	return 0;
}