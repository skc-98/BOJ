#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int ans = 0;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		
		string ss = s.substr(2, s.length() - 1);
		if (stoi(ss) <= 90) ans++;
	}
	cout << ans;
	return 0;
}