#include<iostream>
#include<string>
#include<map>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	map<string, int> mp;
	string s;
	int total = 0;
	while (getline(cin, s) && !s.empty()) {
		mp[s]++;
		total++;
	}

	for (const auto& i : mp) {
		cout << fixed;
		cout.precision(4);
		cout << i.first << " " << (double)i.second/total*100 << '\n';
	}
	return 0;
}