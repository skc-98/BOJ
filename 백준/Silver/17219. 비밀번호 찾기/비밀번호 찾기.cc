#include<iostream>
#include<string>
#include<map>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int n, m;
	cin >> n >> m;

	map<string, string> mp;
	for (int i = 1; i <= n; i++) {
		string a, b;
		cin >> a >> b;
		mp.insert({ a,b });
	}
	for (int i = 1; i <= m; i++) {
		string a;
		cin >> a;
		if (mp.find(a) != mp.end()) cout << mp[a] << '\n';
	}

	return 0;
}