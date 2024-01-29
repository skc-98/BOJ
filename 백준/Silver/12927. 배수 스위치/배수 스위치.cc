#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	int count = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'Y') {
			count++;
			for (int j = i; j < s.length(); j += i+1) {
				if (s[j] == 'N') s[j] = 'Y';
				else s[j] = 'N';
			}
		}
	}
	cout << count;
	return 0;
}