#include<iostream>
using namespace std;

int  main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s1, s2;
	while (cin >> s1 >> s2) {
		bool result=0;
		int point = 0;
		for (int i = 0; i < s2.length(); i++) {
			if (s2[i] == s1[point]) {
				point++;
				if (point == s1.length()) {
					result = 1;
					break;
				}
			}
		}
		if (result)cout << "Yes" << '\n';
		else cout << "No" << '\n';
	}
	return 0;
}