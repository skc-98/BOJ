#include<iostream>
#include<string>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long ans = 0;
	string s;
	cin >> s;
	for (int i = 0; i < s.length(); i++) {
		int n = s[i] - '0';
		ans += pow(n, 5);
	}
	cout << ans;
	return 0;
}