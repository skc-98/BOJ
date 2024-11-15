#include<iostream>
#include<string>
using namespace std;

int  main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	string s1, s2;
	cin >> s1;
	cin >> s2;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < s1.length(); j++) {
			if (s1[j] == '0') s1[j] = '1';
			else s1[j] = '0';
		}
	}
	if (s1 == s2) cout << "Deletion succeeded";
	else cout << "Deletion failed";
	return 0;
}