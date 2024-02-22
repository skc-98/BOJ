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
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '1') {
			if (s[i + 1] == '0') {
				sum += 10;
			}
			else sum += 1;
		}
		else sum += s[i] - '0';
	}

	cout << sum;
	return 0;
}