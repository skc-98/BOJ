#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	cin.ignore();
	for (int i = 0; i < n; i++) {
		string s;
		getline(cin, s);
		if(s[0]>='a' && s[0]<='z') s[0] -= 32;
		cout << s << '\n';
	}

	return 0;
}