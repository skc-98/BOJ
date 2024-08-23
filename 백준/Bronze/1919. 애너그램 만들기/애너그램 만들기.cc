#include<iostream>
#include<string>
#include<cmath>
using namespace std;

int d[150];
int d2[150];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s, ss;
	cin >> s;
	cin >> ss;

	for (int i = 0; i < s.length(); i++) {
		d[s[i]]++;
	}
	for (int i = 0; i < ss.length(); i++) {
		d2[ss[i]]++;
	}

	int ans = 0;
	for (int i = 'a'; i <= 'z'; i++) {
		if (d[i] != d2[i]) {
			ans += abs(d[i] - d2[i]);
		}
	}
	cout << ans;
	return 0;
}