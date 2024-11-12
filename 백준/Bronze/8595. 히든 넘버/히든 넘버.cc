#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int  n;
	cin >> n;

	string s;
	cin >> s;
	long long ans = 0;
	string ss = "";
	for (int i = 0; i < n; i++) {
		if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z')) {
			if(ss!="") ans += stoi(ss);
			ss = "";
		}
		else {
			ss += s[i];
		}
	}
	if (ss != "") ans += stoi(ss);
	cout << ans;
	return 0;
}