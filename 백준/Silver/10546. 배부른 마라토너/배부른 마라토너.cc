#include<iostream>
#include<string>
#include<map>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	map<string, int> mp;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		mp[s]++;
	}

	for (int i = 0; i < n - 1; i++) {
		string s;
		cin >> s;
		mp[s]--;
	}

	string ans;
	for (auto const& i : mp) {
		if (i.second != 0) ans = i.first;
	}
	cout << ans;
	return 0;
}