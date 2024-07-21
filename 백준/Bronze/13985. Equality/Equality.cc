#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	getline(cin, s);

	int a = s[0] - '0';
	int b = s[4] - '0';
	int ans = s[8] - '0';
	if (ans == (a + b)) cout << "YES";
	else cout << "NO";
	return 0;
}