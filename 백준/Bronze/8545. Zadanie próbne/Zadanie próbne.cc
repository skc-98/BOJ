#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;
	reverse(s.begin(), s.end());
	cout << s;
	return 0;
}