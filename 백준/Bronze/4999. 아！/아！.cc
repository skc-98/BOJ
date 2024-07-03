#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string a, b;
	cin >> a >> b;

	if (a.length() >= b.length()) cout << "go";
	else cout << "no";

	return 0;
}