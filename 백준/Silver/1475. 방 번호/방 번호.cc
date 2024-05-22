#include<iostream>
#include<string>
#include<map>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	map<char, int> mp;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '6') mp['9']++;
		else mp[s[i]]++;
	}

	if (mp['9'] % 2 == 0) mp['9'] = mp['9'] / 2;
	else mp['9'] = mp['9'] / 2 + 1;

	int max = 0;
	for (const auto& i : mp) {
		if (max < i.second) max = i.second;
	}
	cout << max;
	return 0;
}