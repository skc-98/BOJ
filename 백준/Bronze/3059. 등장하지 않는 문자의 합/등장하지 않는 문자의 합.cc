#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int d[128] = { 0, };
		string s;
		cin >> s;
		for (int j = 0; j < s.length(); j++) {
			d[s[j]]++;
		}
		int sum = 0;
		for (int j = 'A'; j <= 'Z'; j++) {
			if (d[j] == 0) {
				sum += j;
			}
		}
		cout << sum << '\n';
	}
	return 0;
}