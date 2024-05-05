#include<iostream>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	string s;
	cin >> n;
	cin >> s;

	long long ans = 0;
	long long p = 1;
	for (int i = 0; i < s.length(); i++) {
		ans = (ans + (s[i] - 'a' + 1) * p) % 1234567891;
		p=p*31%1234567891;
	}
	cout << ans;
	return 0;
}